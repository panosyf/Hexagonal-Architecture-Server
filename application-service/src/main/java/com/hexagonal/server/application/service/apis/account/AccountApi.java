package com.hexagonal.server.application.service.apis.account;

import com.hexagonal.server.application.service.model.responses.account.AccountResponse;
import com.hexagonal.server.application.service.model.requests.account.AccountCreateRequest;
import com.hexagonal.server.application.service.model.responses.account.AccountCreationResponse;

import java.math.BigDecimal;

public interface AccountApi {

    AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest);

    AccountResponse getAccount(String id);

    void increaseBalance(String id, BigDecimal amount);

    void decreaseBalance(String id, BigDecimal amount);

}
