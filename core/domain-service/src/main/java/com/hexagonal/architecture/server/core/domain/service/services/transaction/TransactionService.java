package com.hexagonal.architecture.server.core.domain.service.services.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;

public interface TransactionService {

    Transaction getTransaction(Id id);

    Transaction createTransaction(TransactionCreateRequest transactionCreateRequest);

    Transaction updateTransaction(Id id, TransactionUpdateRequest transactionUpdateRequest);

}
