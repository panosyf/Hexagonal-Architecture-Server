package com.hexagonal.server.account.application.service.apis.account;

import com.hexagonal.server.account.application.service.apis.account.AccountApi;
import com.hexagonal.server.account.application.service.model.dtos.account.AccountDto;
import com.hexagonal.server.account.application.service.model.requests.account.AccountCreateRequest;
import com.hexagonal.server.account.application.service.model.responses.account.AccountCreationResponse;
import com.hexagonal.server.account.application.service.model.responses.account.AccountResponse;
import com.hexagonal.server.account.core.domain.entities.account.Account;
import com.hexagonal.server.account.core.domain.model.enums.account.AccountCreationStatusEnum;
import com.hexagonal.server.account.core.domain.service.logic.account.AccountDomainService;
import com.hexagonal.server.account.core.domain.service.model.commands.account.CreateAccountCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.DecreaseBalanceCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.GetAccountCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.account.IncreaseBalanceCommand;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;

public class AccountApiImpl implements AccountApi {

    private final AccountDomainService accountDomainService;
    private final ConversionService conversionService;

    public AccountApiImpl(AccountDomainService accountDomainService, ConversionService conversionService) {
        this.accountDomainService = accountDomainService;
        this.conversionService = conversionService;
    }

    @Override
    public AccountCreationResponse createAccount(AccountCreateRequest accountCreateRequest) {
        CreateAccountCommand createAccountCommand = conversionService.convert(accountCreateRequest, CreateAccountCommand.class);
        Account account = accountDomainService.createAccount(createAccountCommand);
        return new AccountCreationResponse(account.getId().getValue(), AccountCreationStatusEnum.SUCCESSFUL);
    }

    @Override
    public AccountResponse getAccount(String id) {
        GetAccountCommand getAccountCommand = new GetAccountCommand(Id.valueOf(id));
        Account account = accountDomainService.getAccount(getAccountCommand);
        AccountDto accountDto = conversionService.convert(account, AccountDto.class);
        return new AccountResponse(accountDto);
    }

    @Override
    public void increaseBalance(String id, BigDecimal amount) {
        IncreaseBalanceCommand increaseBalanceCommand = new IncreaseBalanceCommand(Id.valueOf(id), Money.of(amount));
        accountDomainService.increaseBalance(increaseBalanceCommand);
    }

    @Override
    public void decreaseBalance(String id, BigDecimal amount) {
        DecreaseBalanceCommand decreaseBalanceCommand = new DecreaseBalanceCommand(Id.valueOf(id), Money.of(amount));
        accountDomainService.decreaseBalance(decreaseBalanceCommand);
    }

}
