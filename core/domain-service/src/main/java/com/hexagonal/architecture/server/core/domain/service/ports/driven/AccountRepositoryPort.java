package com.hexagonal.architecture.server.core.domain.service.ports.driven;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;

import java.math.BigDecimal;

public interface AccountRepositoryPort {

    Account save(Account account);

    // TODO REFACTOR TO RETURN OBJECT OPTIONAL HANDLING SHOULD BE MOVED IN PERSISTENCE
    Account findById(String id);

    BigDecimal findBalance(String id);

    void updateBalance(String id, BigDecimal amount);

    int findTotalEntries();

    void deleteAll();

}