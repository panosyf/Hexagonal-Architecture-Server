package com.hexagonal.server.transaction.application.service.apis.exposed;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.transaction.application.service.apis.external.AccountExternalApi;
import com.hexagonal.server.transaction.application.service.model.dtos.TransactionDto;
import com.hexagonal.server.transaction.application.service.model.requests.TransactionCreateRequest;
import com.hexagonal.server.transaction.application.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.transaction.application.service.model.responses.TransactionCreationResponse;
import com.hexagonal.server.transaction.application.service.model.responses.TransactionResponse;
import com.hexagonal.server.transaction.application.service.model.responses.TransactionUpdateResponse;
import com.hexagonal.server.transaction.core.domain.entities.Transaction;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.transaction.core.domain.service.logic.TransactionDomainService;
import com.hexagonal.server.transaction.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.model.commands.GetTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.model.commands.UpdateTransactionCommand;
import org.springframework.core.convert.ConversionService;

public class TransactionApiImpl implements TransactionApi {

    private final TransactionDomainService transactionDomainService;
    private final AccountExternalApi accountExternalApi;
    private final ConversionService conversionService;

    public TransactionApiImpl(
            TransactionDomainService transactionDomainService,
            AccountExternalApi accountExternalApi,
            ConversionService conversionService) {
        this.transactionDomainService = transactionDomainService;
        this.accountExternalApi = accountExternalApi;
        this.conversionService = conversionService;
    }

    @Override
    public TransactionResponse getTransaction(String id) {
        GetTransactionCommand getTransactionCommand = new GetTransactionCommand(Id.valueOf(id));
        Transaction transaction = transactionDomainService.getTransaction(getTransactionCommand);
        TransactionDto transactionDto = conversionService.convert(transaction, TransactionDto.class);
        return new TransactionResponse(transactionDto);
    }

    @Override
    public TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest) {
        CreateTransactionCommand createTransactionCommand = conversionService.convert(transactionCreateRequest, CreateTransactionCommand.class);
        Transaction transaction = transactionDomainService.createTransaction(createTransactionCommand);
        Id debtorAccountId = transaction.getDebtorAccountId();
        Money amount = transaction.getAmount();
        try {
            accountExternalApi.decreaseBalance(debtorAccountId.getValue(), amount.getValue());
        } catch (Exception e) {
            UpdateTransactionCommand updateTransactionCommand = new UpdateTransactionCommand(transaction.getId(), TransactionStatusEnum.FAILED);
            transactionDomainService.updateTransaction(updateTransactionCommand);
            return new TransactionCreationResponse(null, TransactionStatusEnum.FAILED);
        }
        return new TransactionCreationResponse(transaction.getId().getValue(), TransactionStatusEnum.PENDING);
    }

    @Override
    public TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest) {
        UpdateTransactionCommand updateTransactionCommand = new UpdateTransactionCommand(Id.valueOf(id), transactionUpdateRequest.transactionStatusEnum());
        Transaction updatedTransaction = transactionDomainService.updateTransaction(updateTransactionCommand);
        // TODO THIS IS TEMPORARY, WILL BE REFACTORED UTILIZING STATE PATTERN
        if (updateTransactionCommand.transactionStatusEnum().equals(TransactionStatusEnum.COMPLETED)) {
            accountExternalApi.increaseBalance(updatedTransaction.getBeneficiaryAccountId().getValue(), updatedTransaction.getAmount().getValue());
        }
        return new TransactionUpdateResponse(updatedTransaction.getId().getValue(), updatedTransaction.getStatus());
    }

}
