package com.hexagonal.architecture.server.api.converters.in;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.api.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.core.domain.valueobjects.Email;
import com.hexagonal.architecture.server.core.domain.valueobjects.Name;
import com.hexagonal.architecture.server.core.domain.valueobjects.Password;
import com.hexagonal.architecture.server.core.domain.valueobjects.Username;
import org.springframework.core.convert.converter.Converter;

// TODO CHANGE THIS TO RETURN COMMAND INSTEAD OF DOMAIN OBJECT
public class AccountCreateRequestToAccount implements Converter<AccountCreateRequest, Account> {

    @Override
    public Account convert(AccountCreateRequest accountCreateRequest) {
        Email email = Email.valueOf(accountCreateRequest.email());
        Username username = Username.valueOf(accountCreateRequest.username());
        // TODO UTILIZE HASHING AND SALT
        // TODO HIDE PASSWORD FROM LOGS
        Password password = Password.valueOf(accountCreateRequest.username());
        Name name = Name.valueOf(accountCreateRequest.firstname(), accountCreateRequest.lastname());
        return new Account(email, username, password, name);
    }

}
