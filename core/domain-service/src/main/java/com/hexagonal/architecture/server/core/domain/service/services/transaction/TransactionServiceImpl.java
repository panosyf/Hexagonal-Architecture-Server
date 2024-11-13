package com.hexagonal.architecture.server.core.domain.service.services.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepositoryPort transactionRepositoryPort;

    private final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    public TransactionServiceImpl(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public Transaction getTransaction(Id id) {
        log.info("TransactionServiceImpl");
        return transactionRepositoryPort.findById(id);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepositoryPort.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Id id, TransactionStatusEnum transactionStatusEnum) {
        Transaction transaction = transactionRepositoryPort.findById(id);
        transaction.updateStatus(transactionStatusEnum);
        return transactionRepositoryPort.updateStatus(transaction);
    }

}
