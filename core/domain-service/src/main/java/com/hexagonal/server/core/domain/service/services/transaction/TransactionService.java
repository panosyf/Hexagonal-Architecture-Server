package com.hexagonal.server.core.domain.service.services.transaction;

import com.hexagonal.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.GetTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.UpdateTransactionCommand;

public interface TransactionService {

    Transaction getTransaction(GetTransactionCommand getTransactionCommand);

    Transaction createTransaction(CreateTransactionCommand createTransactionCommand);

    Transaction updateTransaction(UpdateTransactionCommand updateTransactionCommand);

}
