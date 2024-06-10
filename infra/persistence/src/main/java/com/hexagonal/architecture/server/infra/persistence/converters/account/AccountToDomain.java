package com.hexagonal.architecture.server.infra.persistence.converters.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.infra.persistence.entities.AccountEntity;
import org.springframework.core.convert.converter.Converter;

public class AccountToDomain implements Converter<AccountEntity, Account> {

    @Override
    public Account convert(AccountEntity accountEntity) {
        return new Account(
                accountEntity.getId(),
                accountEntity.getName(),
                accountEntity.getBalance(),
                accountEntity.getCreatedAt(),
                accountEntity.getUpdatedAt()
        );
    }

}
