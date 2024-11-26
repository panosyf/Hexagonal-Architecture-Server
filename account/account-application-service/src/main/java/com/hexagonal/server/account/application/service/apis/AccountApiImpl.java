package com.hexagonal.server.account.application.service.apis;

import com.hexagonal.server.account.application.service.model.dtos.AccountDto;
import com.hexagonal.server.account.application.service.model.requests.AccountCreateRequest;
import com.hexagonal.server.account.application.service.model.responses.AccountCreationResponse;
import com.hexagonal.server.account.application.service.model.responses.AccountResponse;
import com.hexagonal.server.account.core.domain.domains.Account;
import com.hexagonal.server.account.core.domain.enums.AccountCreationStatusEnum;
import com.hexagonal.server.account.core.domain.service.commands.CreateAccountCommand;
import com.hexagonal.server.account.core.domain.service.commands.DecreaseBalanceCommand;
import com.hexagonal.server.account.core.domain.service.commands.GetAccountCommand;
import com.hexagonal.server.account.core.domain.service.commands.IncreaseBalanceCommand;
import com.hexagonal.server.account.core.domain.service.services.AccountService;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
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
        CreateAccountCommand createAccountCommand = conversionService.convert(accountCreateRequest, CreateAccountCommand.class);
        Account account = accountService.createAccount(createAccountCommand);
        return new AccountCreationResponse(account.getId().getValue(), AccountCreationStatusEnum.SUCCESSFUL);
    }

    @Override
    public AccountResponse getAccount(String id) {
        GetAccountCommand getAccountCommand = new GetAccountCommand(Id.valueOf(id));
        Account account = accountService.getAccount(getAccountCommand);
        AccountDto accountDto = conversionService.convert(account, AccountDto.class);
        return new AccountResponse(accountDto);
    }

    @Override
    public void increaseBalance(String id, BigDecimal amount) {
        IncreaseBalanceCommand increaseBalanceCommand = new IncreaseBalanceCommand(Id.valueOf(id), Money.of(amount));
        accountService.increaseBalance(increaseBalanceCommand);
    }

    @Override
    public void decreaseBalance(String id, BigDecimal amount) {
        DecreaseBalanceCommand decreaseBalanceCommand = new DecreaseBalanceCommand(Id.valueOf(id), Money.of(amount));
        accountService.decreaseBalance(decreaseBalanceCommand);
    }

}
