package com.hexagonal.architecture.server.core.domain.service.ports.driven;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;

import java.util.Optional;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);

    // TODO REFACTOR TO RETURN OBJECT OPTIONAL HANDLING SHOULD BE MOVED IN PERSISTENCE
    Optional<Transaction> findById(String id);

    void updateStatus(Transaction transaction);

    void deleteAll();

}
