package com.hexagonal.architecture.server.api.converters.out;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.api.model.dtos.AccountDto;
import org.springframework.core.convert.converter.Converter;

public class AccountToDto implements Converter<Account, AccountDto> {

    @Override
    public AccountDto convert(Account account) {
        return new AccountDto(
                account.getName(),
                account.getBalance(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }

}
