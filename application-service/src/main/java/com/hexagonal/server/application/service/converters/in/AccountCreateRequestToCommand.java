package com.hexagonal.server.application.service.converters.in;

import com.hexagonal.server.application.service.model.requests.AccountCreateRequest;
import com.hexagonal.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.server.shared.kernel.common.valueobjects.Email;
import com.hexagonal.server.shared.kernel.common.valueobjects.Name;
import com.hexagonal.server.shared.kernel.common.valueobjects.Password;
import com.hexagonal.server.shared.kernel.common.valueobjects.Username;
import org.springframework.core.convert.converter.Converter;

public class AccountCreateRequestToCommand implements Converter<AccountCreateRequest, CreateAccountCommand> {

    @Override
    public CreateAccountCommand convert(AccountCreateRequest accountCreateRequest) {
        Email email = Email.valueOf(accountCreateRequest.email());
        Username username = Username.valueOf(accountCreateRequest.username());
        // TODO UTILIZE HASHING AND SALT
        // TODO HIDE PASSWORD FROM LOGS
        Password password = Password.valueOf(accountCreateRequest.password());
        Name name = Name.valueOf(accountCreateRequest.firstname(), accountCreateRequest.lastname());
        return new CreateAccountCommand(email, username, password, name);
    }

}
