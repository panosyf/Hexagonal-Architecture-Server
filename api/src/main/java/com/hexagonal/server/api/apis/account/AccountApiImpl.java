package com.hexagonal.server.api.apis.account;

import com.hexagonal.server.api.model.dtos.AccountDto;
import com.hexagonal.server.api.model.requests.AccountCreateRequest;
import com.hexagonal.server.api.model.responses.AccountCreationResponse;
import com.hexagonal.server.api.model.responses.AccountResponse;
import com.hexagonal.server.core.domain.domains.account.Account;
import com.hexagonal.server.core.domain.model.enums.AccountCreationStatusEnum;
import com.hexagonal.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.server.core.domain.service.model.commands.DecreaseBalanceCommand;
import com.hexagonal.server.core.domain.service.model.commands.GetAccountCommand;
import com.hexagonal.server.core.domain.service.model.commands.IncreaseBalanceCommand;
import com.hexagonal.server.core.domain.service.services.account.AccountService;
import com.hexagonal.server.shared.kernel.valueobjects.Id;
import com.hexagonal.server.shared.kernel.valueobjects.Money;
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
