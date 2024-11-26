package com.hexagonal.server.transaction.core.domain.service.services;

import com.hexagonal.server.transaction.core.domain.domains.Transaction;
import com.hexagonal.server.transaction.core.domain.service.commands.CreateTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.GetTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.commands.UpdateTransactionCommand;

public interface TransactionService {

    Transaction getTransaction(GetTransactionCommand getTransactionCommand);

    Transaction createTransaction(CreateTransactionCommand createTransactionCommand);

    Transaction updateTransaction(UpdateTransactionCommand updateTransactionCommand);

}
