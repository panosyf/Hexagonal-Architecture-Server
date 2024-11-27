package com.hexagonal.server.infra.persistence.converters.account;

import com.hexagonal.server.core.domain.entities.account.Account;
import com.hexagonal.server.infra.persistence.daos.AccountDao;
import org.springframework.core.convert.converter.Converter;

public class AccountToEntity implements Converter<Account, AccountDao> {

    @Override
    public AccountDao convert(Account account) {
        return new AccountDao(
                account.getId().getValue(),
                account.getEmail(),
                account.getUsername(),
                account.getPassword(),
                account.getName(),
                account.getBalance(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }

}
