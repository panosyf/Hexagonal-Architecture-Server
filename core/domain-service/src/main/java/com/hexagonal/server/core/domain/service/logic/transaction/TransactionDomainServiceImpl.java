package com.hexagonal.server.core.domain.service.logic.transaction;

import com.hexagonal.server.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.GetTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.UpdateTransactionCommand;
import com.hexagonal.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionDomainServiceImpl implements TransactionDomainService {

    private final TransactionRepositoryPort transactionRepositoryPort;

    private final Logger log = LoggerFactory.getLogger(TransactionDomainServiceImpl.class);

    public TransactionDomainServiceImpl(TransactionRepositoryPort transactionRepositoryPort) {
        this.transactionRepositoryPort = transactionRepositoryPort;
    }

    @Override
    public Transaction getTransaction(GetTransactionCommand getTransactionCommand) {
        log.info("TransactionDomainServiceImpl");
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
