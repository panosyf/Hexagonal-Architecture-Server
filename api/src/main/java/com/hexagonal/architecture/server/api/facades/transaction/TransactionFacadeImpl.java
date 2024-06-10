package com.hexagonal.architecture.server.api.facades.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.api.model.dtos.TransactionDto;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionService;
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;

public class TransactionFacadeImpl implements TransactionFacade {

    private final TransactionService transactionService;
    private final AccountService accountService;
    private final ConversionService conversionService;

    public TransactionFacadeImpl(
            TransactionService transactionService,
            AccountService accountService,
            ConversionService conversionService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.conversionService = conversionService;
    }

    @Override
    public TransactionDto getTransaction(String id) {
        return  conversionService.convert(transactionService.getTransaction(id), TransactionDto.class);
    }

    @Override
    public TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest) {
        String debtorAccountId = transactionCreateRequest.debtorAccountId();
        BigDecimal amount = transactionCreateRequest.amount();
        Transaction transaction = transactionService.createTransaction(transactionCreateRequest);
        try {
            accountService.decreaseBalance(debtorAccountId, amount);
        } catch (Exception e) {
            String id = transaction.getId();
            TransactionUpdateRequest transactionUpdateRequest = new TransactionUpdateRequest(TransactionStatusEnum.FAILED);
            transactionService.updateTransaction(id, transactionUpdateRequest);
            return new TransactionCreationResponse(TransactionStatusEnum.FAILED, null);
        }
        return new TransactionCreationResponse(TransactionStatusEnum.PENDING, transaction.getId());
    }

    @Override
    public TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest) {
        TransactionStatusEnum transactionStatusEnum = transactionUpdateRequest.transactionStatusEnum();
        transactionService.updateTransaction(id, transactionUpdateRequest);
        return new TransactionUpdateResponse(transactionStatusEnum);
    }

}
