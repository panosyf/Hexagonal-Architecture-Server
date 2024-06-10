package com.hexagonal.architecture.server.core.domain.service.services.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.exceptions.notfound.TransactionNotFoundException;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepositoryPort transactionRepositoryPort;

    private final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    public TransactionServiceImpl(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public Transaction getTransaction(String id) {
        log.info("TransactionServiceImpl");
        return transactionRepositoryPort.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    @Override
    public Transaction createTransaction(TransactionCreateRequest transactionCreateRequest) {
        Transaction transaction = new Transaction(
                transactionCreateRequest.transactionType(),
                transactionCreateRequest.amount(),
                transactionCreateRequest.description(),
                transactionCreateRequest.debtorAccountId(),
                transactionCreateRequest.beneficiaryAccountId(),
                TransactionStatusEnum.CREATED
        );
        return transactionRepositoryPort.save(transaction);
    }

    @Override
    public void updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest) {
        TransactionStatusEnum transactionStatusEnum = transactionUpdateRequest.transactionStatusEnum();
        Transaction transaction = transactionRepositoryPort.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
        transaction.updateStatus(transactionStatusEnum);
        transactionRepositoryPort.updateStatus(transaction);
    }

}
