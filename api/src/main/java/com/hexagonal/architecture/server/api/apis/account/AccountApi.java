package com.hexagonal.architecture.server.api.apis.account;

import com.hexagonal.architecture.server.api.model.responses.AccountResponse;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.api.model.responses.AccountCreationResponse;

import java.math.BigDecimal;

public interface AccountApi {

    AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest);

    AccountResponse getAccount(String id);

    void increaseBalance(String id, BigDecimal amount);

    void decreaseBalance(String id, BigDecimal amount);

}
