package com.hexagonal.server.transaction.infra.persistence.converters.account;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.transaction.core.domain.domains.account.Account;
import com.hexagonal.server.transaction.infra.persistence.daos.AccountDao;
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
