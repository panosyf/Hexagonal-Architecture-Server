package com.hexagonal.architecture.server.infra.persistence.converters.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.infra.persistence.entities.AccountEntity;
import org.springframework.core.convert.converter.Converter;

public class AccountToEntity implements Converter<Account, AccountEntity> {

    @Override
    public AccountEntity convert(Account account) {
        return new AccountEntity(
                account.getId(),
                account.getName(),
                account.getBalance(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }

}
