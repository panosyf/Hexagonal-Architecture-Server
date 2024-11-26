package com.hexagonal.server.account.core.domain.service.driven;

import com.hexagonal.server.account.core.domain.domains.transaction.Transaction;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction);

    Transaction findById(Id id);

    Transaction updateStatus(Transaction transaction);

    void deleteAll();

}
