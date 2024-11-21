package com.hexagonal.server.api.apis.transaction;

import com.hexagonal.server.api.apis.account.AccountApi;
import com.hexagonal.server.api.model.dtos.TransactionDto;
import com.hexagonal.server.api.model.requests.TransactionCreateRequest;
import com.hexagonal.server.api.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.server.api.model.responses.TransactionResponse;
import com.hexagonal.server.api.model.responses.TransactionUpdateResponse;
import com.hexagonal.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.GetTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.UpdateTransactionCommand;
import com.hexagonal.server.core.domain.service.services.transaction.TransactionService;
import com.hexagonal.server.shared.kernel.valueobjects.Id;
import com.hexagonal.server.shared.kernel.valueobjects.Money;
import org.springframework.core.convert.ConversionService;

public class TransactionApiImpl implements TransactionApi {

    private final TransactionService transactionService;
    private final AccountApi accountApi;
    private final ConversionService conversionService;

    public TransactionApiImpl(
            TransactionService transactionService,
            AccountApi accountApi,
            ConversionService conversionService) {
        this.transactionService = transactionService;
        this.accountApi = accountApi;
        this.conversionService = conversionService;
    }

    @Override
    public TransactionResponse getTransaction(String id) {
        GetTransactionCommand getTransactionCommand = new GetTransactionCommand(Id.valueOf(id));
        Transaction transaction = transactionService.getTransaction(getTransactionCommand);
        TransactionDto transactionDto = conversionService.convert(transaction, TransactionDto.class);
        return new TransactionResponse(transactionDto);
    }

    @Override
    public TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest) {
        CreateTransactionCommand createTransactionCommand = conversionService.convert(transactionCreateRequest, CreateTransactionCommand.class);
        Transaction transaction = transactionService.createTransaction(createTransactionCommand);
        Id debtorAccountId = transaction.getDebtorAccountId();
        Money amount = transaction.getAmount();
        try {
            accountApi.decreaseBalance(debtorAccountId.getValue(), amount.getValue());
        } catch (Exception e) {
            UpdateTransactionCommand updateTransactionCommand = new UpdateTransactionCommand(transaction.getId(), TransactionStatusEnum.FAILED);
            transactionService.updateTransaction(updateTransactionCommand);
            return new TransactionCreationResponse(null, TransactionStatusEnum.FAILED);
        }
        return new TransactionCreationResponse(transaction.getId().getValue(), TransactionStatusEnum.PENDING);
    }

    @Override
    public TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest) {
        UpdateTransactionCommand updateTransactionCommand = new UpdateTransactionCommand(Id.valueOf(id), transactionUpdateRequest.transactionStatusEnum());
        Transaction updatedTransaction = transactionService.updateTransaction(updateTransactionCommand);
        // TODO THIS IS TEMPORARY, WILL BE REFACTORED UTILIZING STATE PATTERN
        if (updateTransactionCommand.transactionStatusEnum().equals(TransactionStatusEnum.COMPLETED)) {
            accountApi.increaseBalance(updatedTransaction.getBeneficiaryAccountId().getValue(), updatedTransaction.getAmount().getValue());
        }
        return new TransactionUpdateResponse(updatedTransaction.getId().getValue(), updatedTransaction.getStatus());
    }

}
