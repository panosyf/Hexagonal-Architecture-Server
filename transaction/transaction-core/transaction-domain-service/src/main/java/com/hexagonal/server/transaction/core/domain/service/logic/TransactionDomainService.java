package com.hexagonal.server.transaction.core.domain.service.logic;

import com.hexagonal.server.transaction.core.domain.entities.Transaction;
import com.hexagonal.server.transaction.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.model.commands.GetTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.model.commands.UpdateTransactionCommand;

public interface TransactionDomainService {

    Transaction getTransaction(GetTransactionCommand getTransactionCommand);

    Transaction createTransaction(CreateTransactionCommand createTransactionCommand);

    Transaction updateTransaction(UpdateTransactionCommand updateTransactionCommand);

}
