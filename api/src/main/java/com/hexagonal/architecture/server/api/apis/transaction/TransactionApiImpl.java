package com.hexagonal.architecture.server.api.apis.transaction;

import com.hexagonal.architecture.server.api.apis.account.AccountApi;
import com.hexagonal.architecture.server.api.model.dtos.TransactionDto;
import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;
import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionService;
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;

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
        TransactionDto transactionDto = conversionService.convert(transactionService.getTransaction(id), TransactionDto.class);
        return new TransactionResponse(transactionDto);
    }

    @Override
    public TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest) {
        String debtorAccountId = transactionCreateRequest.debtorAccountId();
        BigDecimal amount = transactionCreateRequest.amount();
        Transaction transaction = transactionService.createTransaction(transactionCreateRequest);
        try {
            accountApi.decreaseBalance(debtorAccountId, amount);
        } catch (Exception e) {
            String id = transaction.getId();
            TransactionUpdateRequest transactionUpdateRequest = new TransactionUpdateRequest(TransactionStatusEnum.FAILED);
            transactionService.updateTransaction(id, transactionUpdateRequest);
            return new TransactionCreationResponse(null, TransactionStatusEnum.FAILED);
        }
        return new TransactionCreationResponse(transaction.getId(), TransactionStatusEnum.PENDING);
    }

    @Override
    public TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionUpdateRequest);
        // TODO THIS IS TEMPORARY, WILL BE REFACTORED UTILIZING STATE PATTERN
        if (transactionUpdateRequest.transactionStatusEnum().equals(TransactionStatusEnum.COMPLETED)) {
            accountApi.increaseBalance(updatedTransaction.getBeneficiaryAccountId(), updatedTransaction.getAmount());
        }
        return new TransactionUpdateResponse(updatedTransaction.getId(), updatedTransaction.getStatus());
    }

}
