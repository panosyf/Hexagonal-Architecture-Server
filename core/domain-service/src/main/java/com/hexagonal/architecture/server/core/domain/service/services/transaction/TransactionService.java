package com.hexagonal.architecture.server.core.domain.service.services.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;

public interface TransactionService {

    Transaction getTransaction(Id id);

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(Id id, TransactionStatusEnum transactionStatusEnum);

}
