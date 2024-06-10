package com.hexagonal.architecture.server.core.domain.service.services.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;

public interface TransactionService {

    Transaction getTransaction(String id);

    Transaction createTransaction(TransactionCreateRequest transactionCreateRequest);

    void updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest);

}
