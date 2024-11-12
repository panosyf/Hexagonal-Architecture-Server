package com.hexagonal.architecture.server.core.domain.service.ports.driven;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

import java.math.BigDecimal;

public interface AccountRepositoryPort {

    Account save(Account account);

    Account findById(String id);

    Money findBalance(String id);

    Account updateBalance(Account account);

    int findTotalEntries();

    void deleteAll();

}
