package com.hexagonal.architecture.server.api.converters.in;

import com.hexagonal.architecture.server.api.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.architecture.server.core.domain.valueobjects.Email;
import com.hexagonal.architecture.server.core.domain.valueobjects.Name;
import com.hexagonal.architecture.server.core.domain.valueobjects.Password;
import com.hexagonal.architecture.server.core.domain.valueobjects.Username;
import org.springframework.core.convert.converter.Converter;

public class AccountCreateRequestToCommand implements Converter<AccountCreateRequest, CreateAccountCommand> {

    @Override
    public CreateAccountCommand convert(AccountCreateRequest accountCreateRequest) {
        Email email = Email.valueOf(accountCreateRequest.email());
        Username username = Username.valueOf(accountCreateRequest.username());
        // TODO UTILIZE HASHING AND SALT
        // TODO HIDE PASSWORD FROM LOGS
        Password password = Password.valueOf(accountCreateRequest.username());
        Name name = Name.valueOf(accountCreateRequest.firstname(), accountCreateRequest.lastname());
        return new CreateAccountCommand(email, username, password, name);
    }

}
