package com.hexagonal.architecture.server.infra.persistence.converters.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.infra.persistence.daos.AccountDao;
import org.springframework.core.convert.converter.Converter;

public class AccountToEntity implements Converter<Account, AccountDao> {

    @Override
    public AccountDao convert(Account account) {
        return new AccountDao(
                account.getId(),
                account.getName(),
                account.getBalance(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }

}
