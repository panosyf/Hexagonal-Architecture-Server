package com.hexagonal.server.infra.persistence.converter.account;

import com.hexagonal.server.account.core.domain.account.Account;
import com.hexagonal.server.infra.persistence.entity.account.AccountEntity;
import org.springframework.core.convert.converter.Converter;

public class AccountToEntity implements Converter<Account, AccountEntity> {

    @Override
    public AccountEntity convert(Account account) {
        return new AccountEntity(
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
