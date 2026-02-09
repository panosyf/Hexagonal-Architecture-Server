package com.hexagonal.server.infra.persistence.converters.account;

import com.hexagonal.server.account.core.domain.entities.account.Account;
import com.hexagonal.server.infra.persistence.daos.account.AccountDao;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import org.springframework.core.convert.converter.Converter;

public class AccountToDomain implements Converter<AccountDao, Account> {

    @Override
    public Account convert(AccountDao accountDao) {
        return new Account(
                Id.valueOf(accountDao.getId()),
                accountDao.getEmail(),
                accountDao.getUsername(),
                accountDao.getPassword(),
                accountDao.getName(),
                accountDao.getBalance(),
                accountDao.getCreatedAt(),
                accountDao.getUpdatedAt()
        );
    }

}
