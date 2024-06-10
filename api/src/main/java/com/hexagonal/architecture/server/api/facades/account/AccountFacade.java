package com.hexagonal.architecture.server.api.facades.account;

import com.hexagonal.architecture.server.api.model.dtos.AccountDto;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.api.model.responses.AccountCreationResponse;

public interface AccountFacade {

    AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest);

    AccountDto getAccount(String id);

}
