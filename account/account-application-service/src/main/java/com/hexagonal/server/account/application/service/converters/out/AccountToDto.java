package com.hexagonal.server.account.application.service.converters.out;

import com.hexagonal.server.account.application.service.model.dtos.AccountDto;
import com.hexagonal.server.account.core.domain.entities.Account;
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
