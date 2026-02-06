package com.hexagonal.server.account.core.domain.service.logic.transaction;

import com.hexagonal.server.account.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.account.core.domain.service.model.commands.transaction.CreateTransactionCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.transaction.GetTransactionCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.transaction.UpdateTransactionCommand;

public interface TransactionDomainService {

    Transaction getTransaction(GetTransactionCommand getTransactionCommand);

    Transaction createTransaction(CreateTransactionCommand createTransactionCommand);

    Transaction updateTransaction(UpdateTransactionCommand updateTransactionCommand);

}
