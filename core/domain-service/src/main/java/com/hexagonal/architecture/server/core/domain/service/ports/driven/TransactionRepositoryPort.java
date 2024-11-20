package com.hexagonal.architecture.server.core.domain.service.ports.driven;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.shared.kernel.valueobjects.Id;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);

    Transaction findById(Id id);

    Transaction updateStatus(Transaction transaction);

    void deleteAll();

}
