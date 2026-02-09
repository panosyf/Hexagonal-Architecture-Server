package com.hexagonal.server.account.application.apis.account;

import com.hexagonal.server.account.application.model.requests.account.AccountCreateRequest;
import com.hexagonal.server.account.application.model.responses.account.AccountCreationResponse;
import com.hexagonal.server.account.application.model.responses.account.AccountResponse;

import java.math.BigDecimal;

public interface AccountApi {

    AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest);

    AccountResponse getAccount(String id);

    void increaseBalance(String id, BigDecimal amount);

    void decreaseBalance(String id, BigDecimal amount);

}
