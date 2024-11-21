package com.hexagonal.server.api.converters.out;

import com.hexagonal.server.core.domain.domains.account.Account;
import com.hexagonal.server.api.model.dtos.AccountDto;
import org.springframework.core.convert.converter.Converter;

public class AccountToDto implements Converter<Account, AccountDto> {

    @Override
    public AccountDto convert(Account account) {
        return new AccountDto(
                account.getId().getValue(),
                account.getName().getFirstName(),
                account.getName().getLastName(),
                account.getBalance().getValue(),
                account.getCreatedAt().getTime(),
                account.getUpdatedAt().getTime()
        );
    }

}