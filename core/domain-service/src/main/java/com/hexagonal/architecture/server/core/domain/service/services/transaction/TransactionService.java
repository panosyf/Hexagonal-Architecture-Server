package com.hexagonal.architecture.server.core.domain.service.services.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;

public interface TransactionService {

    // TODO USE COMMAND AS INPUT
    Transaction getTransaction(Id id);

    // TODO USE COMMAND AS INPUT
    Transaction createTransaction(CreateTransactionCommand createTransactionCommand);

    // TODO USE COMMAND AS INPUT
    Transaction updateTransaction(Id id, TransactionStatusEnum transactionStatusEnum);

}
