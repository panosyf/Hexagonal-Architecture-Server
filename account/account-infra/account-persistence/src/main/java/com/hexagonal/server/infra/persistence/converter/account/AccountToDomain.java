package com.hexagonal.server.infra.persistence.converter.account;

import com.hexagonal.server.account.core.domain.account.Account;
import com.hexagonal.server.infra.persistence.entity.account.AccountEntity;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import org.springframework.core.convert.converter.Converter;

public class AccountToDomain implements Converter<AccountEntity, Account> {

    @Override
    public Account convert(AccountEntity accountEntity) {
        return new Account(
                Id.valueOf(accountEntity.getId()),
                accountEntity.getEmail(),
                accountEntity.getUsername(),
                accountEntity.getPassword(),
                accountEntity.getName(),
                accountEntity.getBalance(),
                accountEntity.getCreatedAt(),
                accountEntity.getUpdatedAt()
        );
    }

}
