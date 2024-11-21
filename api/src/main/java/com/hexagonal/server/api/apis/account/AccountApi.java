package com.hexagonal.server.api.apis.account;

import com.hexagonal.server.api.model.responses.AccountResponse;
import com.hexagonal.server.api.model.requests.AccountCreateRequest;
import com.hexagonal.server.api.model.responses.AccountCreationResponse;

import java.math.BigDecimal;

public interface AccountApi {

    AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest);

    AccountResponse getAccount(String id);

    void increaseBalance(String id, BigDecimal amount);

    void decreaseBalance(String id, BigDecimal amount);

}
