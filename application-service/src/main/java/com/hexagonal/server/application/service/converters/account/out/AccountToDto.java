package com.hexagonal.server.application.service.converters.account.out;

import com.hexagonal.server.application.service.model.dtos.account.AccountDto;
import com.hexagonal.server.core.domain.entities.account.Account;
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
