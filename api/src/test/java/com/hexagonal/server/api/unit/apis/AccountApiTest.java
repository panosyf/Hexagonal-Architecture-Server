package com.hexagonal.server.api.unit.apis;

import com.hexagonal.server.api.apis.account.AccountApi;
import com.hexagonal.server.api.apis.account.AccountApiImpl;
import com.hexagonal.server.api.common.constants.*;
import com.hexagonal.server.api.converters.in.AccountCreateRequestToCommand;
import com.hexagonal.server.api.converters.out.AccountToDto;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.core.convert.support.GenericConversionService;

import java.math.BigDecimal;

import static com.hexagonal.server.api.common.mocks.AccountCreateRequestMocks.generateAccountCreateRequest;
import static com.hexagonal.server.api.common.mocks.AccountMocks.generateAccount;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class AccountApiTest {

    private final AccountService accountService = mock(AccountService.class);
    private final GenericConversionService genericConversionService = new GenericConversionService();
    private AccountApi accountApi;
    private final ArgumentCaptor<CreateAccountCommand> createAccountCommandCaptor = ArgumentCaptor.forClass(CreateAccountCommand.class);
    private final ArgumentCaptor<GetAccountCommand> getAccountCommandCaptor = ArgumentCaptor.forClass(GetAccountCommand.class);
    private final ArgumentCaptor<IncreaseBalanceCommand> increaseBalanceCommandCaptor = ArgumentCaptor.forClass(IncreaseBalanceCommand.class);
    private final ArgumentCaptor<DecreaseBalanceCommand> decreaseBalanceCommandCaptor = ArgumentCaptor.forClass(DecreaseBalanceCommand.class);

    @BeforeEach
    void init() {
        genericConversionService.addConverter(new AccountToDto());
        genericConversionService.addConverter(new AccountCreateRequestToCommand());
        accountApi = new AccountApiImpl(accountService, genericConversionService);
    }

    @Test
    void createAccountTest() {
        // given
        AccountCreateRequest accountCreateRequest = generateAccountCreateRequest();
        Account account = generateAccount();
        given(accountService.createAccount(any(CreateAccountCommand.class)))
                .willReturn(account);
        // when
        AccountCreationResponse accountCreationResponse = accountApi.createAccount(accountCreateRequest);
        // then
        verify(accountService, times(1))
                .createAccount(createAccountCommandCaptor.capture());
        CreateAccountCommand createAccountCommand = createAccountCommandCaptor.getValue();
        assertAll(
                () -> assertEquals(Emails.EMAIL_1, createAccountCommand.email()),
                () -> assertEquals(Usernames.USERNAME_1, createAccountCommand.username()),
                () -> assertEquals(Passwords.PASSWORD_1, createAccountCommand.password()),
                () -> assertEquals(Names.ACCOUNT_NAME_1, createAccountCommand.name()),
                () -> assertEquals(AccountCreationStatusEnum.SUCCESSFUL, accountCreationResponse.status()),
                () -> assertEquals(account.getId().getValue(), accountCreationResponse.id())
        );
    }

    @Test
    void getAccountTest() {
        // given
        Id accountId1 = Ids.ACCOUNT_ID_1;
        Account account = generateAccount();
        given(accountService.getAccount(any(GetAccountCommand.class)))
                .willReturn(account);
        // when
        AccountResponse accountResponse = accountApi.getAccount(accountId1.getValue());
        // then
        verify(accountService, times(1))
                .getAccount(getAccountCommandCaptor.capture());
        GetAccountCommand getAccountCommand = getAccountCommandCaptor.getValue();
        AccountDto accountDto = accountResponse.accountDto();
        assertAll(
                () -> assertEquals(accountId1, getAccountCommand.id()),
                () -> assertEquals(Names.ACCOUNT_NAME_1.getFirstName(), accountDto.firstname()),
                () -> assertEquals(Names.ACCOUNT_NAME_1.getLastName(), accountDto.lastname()),
                () -> assertEquals(Money.zero().getValue(), accountDto.balance()),
                () -> assertEquals(account.getCreatedAt().getTime(), accountDto.createdAt()),
                () -> assertEquals(account.getUpdatedAt().getTime(), accountDto.updatedAt())
        );
    }

    @Test
    void increaseBalanceTest() {
        // given
        Id accountId1 = Ids.ACCOUNT_ID_1;
        Money money = Money.of(BigDecimal.TEN);
        // when
        accountApi.increaseBalance(accountId1.getValue(), money.getValue());
        // then
        verify(accountService, times(1))
                .increaseBalance(increaseBalanceCommandCaptor.capture());
        IncreaseBalanceCommand increaseBalanceCommand = increaseBalanceCommandCaptor.getValue();
        assertAll(
                () -> assertEquals(accountId1, increaseBalanceCommand.id()),
                () -> assertEquals(money, increaseBalanceCommand.amount())
        );
    }

    @Test
    void decreaseBalanceTest() {
        // given
        Id accountId1 = Ids.ACCOUNT_ID_1;
        Money money = Money.of(BigDecimal.TEN);
        // when
        accountApi.decreaseBalance(accountId1.getValue(), money.getValue());
        // then
        verify(accountService, times(1))
                .decreaseBalance(decreaseBalanceCommandCaptor.capture());
        DecreaseBalanceCommand decreaseBalanceCommand = decreaseBalanceCommandCaptor.getValue();
        assertAll(
                () -> assertEquals(accountId1, decreaseBalanceCommand.id()),
                () -> assertEquals(money, decreaseBalanceCommand.amount())
        );
    }

}
