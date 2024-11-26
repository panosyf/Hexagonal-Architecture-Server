package com.hexagonal.server.account.application.service.apis.account;

import com.hexagonal.server.account.application.service.model.requests.AccountCreateRequest;
import com.hexagonal.server.account.application.service.model.responses.AccountCreationResponse;
import com.hexagonal.server.account.application.service.model.responses.AccountResponse;

import java.math.BigDecimal;

public interface AccountApi {

    AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest);

    AccountResponse getAccount(String id);

    void increaseBalance(String id, BigDecimal amount);

    void decreaseBalance(String id, BigDecimal amount);

}
