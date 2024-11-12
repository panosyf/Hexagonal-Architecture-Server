package com.hexagonal.architecture.server.api.apis.account;

import com.hexagonal.architecture.server.api.model.responses.AccountResponse;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.api.model.responses.AccountCreationResponse;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

import java.math.BigDecimal;

public interface AccountApi {

    AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest);

    AccountResponse getAccount(Id id);

    void increaseBalance(Id id, Money amount);

    void decreaseBalance(Id id, Money amount);

}
