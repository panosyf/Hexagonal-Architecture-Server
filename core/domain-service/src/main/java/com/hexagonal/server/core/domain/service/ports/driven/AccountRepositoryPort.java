package com.hexagonal.server.core.domain.service.ports.driven;

import com.hexagonal.server.core.domain.entities.account.Account;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

public interface AccountRepositoryPort {

    Account save(Account account);

    Account findById(Id id);

    Money findBalance(Id id);

    Account updateBalance(Account account);

    int findTotalEntries();

    void deleteAll();

}
