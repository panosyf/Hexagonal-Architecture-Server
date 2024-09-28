package com.hexagonal.architecture.server.api.facades.account;

import com.hexagonal.architecture.server.api.model.dtos.AccountDto;
import com.hexagonal.architecture.server.api.model.responses.AccountCreationResponse;
import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.model.enums.AccountCreationStatusEnum;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import org.springframework.core.convert.ConversionService;

public class AccountFacadeImpl implements AccountFacade {

    private final AccountService accountService;
    private final ConversionService conversionService;

    public AccountFacadeImpl(AccountService accountService, ConversionService conversionService) {
        this.accountService = accountService;
        this.conversionService = conversionService;
    }

    public AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest) {
        Account account = accountService.createAccount(accountCreateRequest);
        return new AccountCreationResponse(account.getId(), AccountCreationStatusEnum.SUCCESSFUL);
    }

    public AccountDto getAccount(String id) {
        return conversionService.convert(accountService.getAccount(id), AccountDto.class);
    }

}
