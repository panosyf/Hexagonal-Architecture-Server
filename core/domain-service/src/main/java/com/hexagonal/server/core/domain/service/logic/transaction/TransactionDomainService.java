package com.hexagonal.server.core.domain.service.logic.transaction;

import com.hexagonal.server.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.GetTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.UpdateTransactionCommand;

public interface TransactionDomainService {

    Transaction getTransaction(GetTransactionCommand getTransactionCommand);

    Transaction createTransaction(CreateTransactionCommand createTransactionCommand);

    Transaction updateTransaction(UpdateTransactionCommand updateTransactionCommand);

}
