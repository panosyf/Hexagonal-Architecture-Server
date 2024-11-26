package com.hexagonal.server.transaction.core.domain.service.services.transaction;

import com.hexagonal.server.transaction.core.domain.domains.transaction.Transaction;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.transaction.core.domain.service.commands.CreateTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.GetTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.UpdateTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.driven.TransactionRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepositoryPort transactionRepositoryPort;

    private final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    public TransactionServiceImpl(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public Transaction getTransaction(GetTransactionCommand getTransactionCommand) {
        log.info("TransactionServiceImpl");
        return transactionRepositoryPort.findById(getTransactionCommand.id());
    }

    @Override
    public Transaction createTransaction(CreateTransactionCommand createTransactionCommand) {
        Transaction transaction = new Transaction(
                createTransactionCommand.type(),
                createTransactionCommand.amount(),
                createTransactionCommand.description(),
                createTransactionCommand.debtorAccountId(),
                createTransactionCommand.beneficiaryAccountId(),
                TransactionStatusEnum.PENDING
        );
        return transactionRepositoryPort.save(transaction);
    }

    @Override
    public Transaction updateTransaction(UpdateTransactionCommand updateTransactionCommand) {
        Transaction transaction = transactionRepositoryPort.findById(updateTransactionCommand.id());
        transaction.updateStatus(updateTransactionCommand.transactionStatusEnum());
        return transactionRepositoryPort.updateStatus(transaction);
    }

}
