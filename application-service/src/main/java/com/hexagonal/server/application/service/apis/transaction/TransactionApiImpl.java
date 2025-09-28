package com.hexagonal.server.application.service.apis.transaction;

import com.hexagonal.server.application.service.apis.account.AccountApi;
import com.hexagonal.server.application.service.model.dtos.TransactionDto;
import com.hexagonal.server.application.service.model.requests.TransactionCreateRequest;
import com.hexagonal.server.application.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.application.service.model.responses.TransactionCreationResponse;
import com.hexagonal.server.application.service.model.responses.TransactionResponse;
import com.hexagonal.server.application.service.model.responses.TransactionUpdateResponse;
import com.hexagonal.server.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.GetTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.UpdateTransactionCommand;
import com.hexagonal.server.core.domain.service.logic.transaction.TransactionDomainService;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import org.springframework.core.convert.ConversionService;

public class TransactionApiImpl implements TransactionApi {

    private final TransactionDomainService transactionDomainService;
    private final AccountApi accountApi;
    private final ConversionService conversionService;

    public TransactionApiImpl(
            TransactionDomainService transactionDomainService,
            AccountApi accountApi,
            ConversionService conversionService) {
        this.transactionDomainService = transactionDomainService;
        this.accountApi = accountApi;
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
            accountApi.decreaseBalance(debtorAccountId.getValue(), amount.getValue());
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
            accountApi.increaseBalance(updatedTransaction.getBeneficiaryAccountId().getValue(), updatedTransaction.getAmount().getValue());
        }
        return new TransactionUpdateResponse(updatedTransaction.getId().getValue(), updatedTransaction.getStatus());
    }

}
