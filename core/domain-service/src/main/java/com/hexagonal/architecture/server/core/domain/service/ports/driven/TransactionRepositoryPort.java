package com.hexagonal.architecture.server.core.domain.service.ports.driven;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);

    Transaction findById(String id);

    void updateStatus(Transaction transaction);

    void deleteAll();

}
