package com.hexagonal.server.core.domain.service.ports.driven;

import com.hexagonal.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);

    Transaction findById(Id id);

    Transaction updateStatus(Transaction transaction);

    void deleteAll();

}
