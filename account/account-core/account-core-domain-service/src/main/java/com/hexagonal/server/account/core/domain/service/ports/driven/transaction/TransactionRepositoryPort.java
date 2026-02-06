package com.hexagonal.server.account.core.domain.service.ports.driven.transaction;

import com.hexagonal.server.account.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);

    Transaction findById(Id id);

    Transaction updateStatus(Transaction transaction);

    void deleteAll();

}
