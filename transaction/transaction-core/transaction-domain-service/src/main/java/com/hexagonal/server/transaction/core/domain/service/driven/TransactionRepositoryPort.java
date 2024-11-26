package com.hexagonal.server.transaction.core.domain.service.driven;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.transaction.core.domain.domains.transaction.Transaction;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);

    Transaction findById(Id id);

    Transaction updateStatus(Transaction transaction);

    void deleteAll();

}
