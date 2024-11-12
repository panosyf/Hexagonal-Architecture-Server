package com.hexagonal.architecture.server.api.apis.account;

import com.hexagonal.architecture.server.api.model.dtos.AccountDto;
import com.hexagonal.architecture.server.api.model.responses.AccountCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.AccountResponse;
import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.model.enums.AccountCreationStatusEnum;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;

public class AccountApiImpl implements AccountApi {

    private final AccountService accountService;
    private final ConversionService conversionService;

    public AccountApiImpl(AccountService accountService, ConversionService conversionService) {
        this.accountService = accountService;
        this.conversionService = conversionService;
    }

    @Override
    public AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest) {
        Account createdAccount = accountService.createAccount(conversionService.convert(accountCreateRequest, Account.class));
        return new AccountCreationResponse(createdAccount.getId().getValue(), AccountCreationStatusEnum.SUCCESSFUL);
    }

    @Override
    public AccountResponse getAccount(String id) {
        AccountDto accountDto = conversionService.convert(accountService.getAccount(id), AccountDto.class);
        return new AccountResponse(accountDto);
    }

    @Override
    public void increaseBalance(String id, BigDecimal amount) {
        accountService.increaseBalance(id, amount);
    }

    @Override
    public void decreaseBalance(String id, BigDecimal amount) {
        accountService.decreaseBalance(id, amount);
    }

}
