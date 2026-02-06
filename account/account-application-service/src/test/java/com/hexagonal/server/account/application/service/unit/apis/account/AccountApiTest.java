package com.hexagonal.server.account.application.service.unit.apis.account;

import com.hexagonal.server.account.application.service.apis.account.AccountApi;
import com.hexagonal.server.account.application.service.apis.account.AccountApiImpl;
import com.hexagonal.server.account.application.service.common.constants.account.Emails;
import com.hexagonal.server.account.application.service.common.constants.account.Names;
import com.hexagonal.server.account.application.service.common.constants.account.Passwords;
import com.hexagonal.server.account.application.service.common.constants.account.Usernames;
import com.hexagonal.server.account.application.service.common.constants.transaction.Ids;
import com.hexagonal.server.account.application.service.converters.account.in.AccountCreateRequestToCommand;
import com.hexagonal.server.account.application.service.converters.account.out.AccountToDto;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.core.convert.support.GenericConversionService;

import java.math.BigDecimal;

import static com.hexagonal.server.account.application.service.common.mocks.account.AccountCreateRequestMocks.generateAccountCreateRequest;
import static com.hexagonal.server.account.application.service.common.mocks.account.AccountMocks.generateAccount;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class AccountApiTest {

    private final AccountDomainService accountDomainService = mock(AccountDomainService.class);
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
        accountApi = new AccountApiImpl(accountDomainService, genericConversionService);
    }

    @Test
    void createAccountTest() {
        // given
        AccountCreateRequest accountCreateRequest = generateAccountCreateRequest();
        Account account = generateAccount();
        given(accountDomainService.createAccount(any(CreateAccountCommand.class)))
                .willReturn(account);
        // when
        AccountCreationResponse accountCreationResponse = accountApi.createAccount(accountCreateRequest);
        // then
        verify(accountDomainService, times(1))
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
        given(accountDomainService.getAccount(any(GetAccountCommand.class)))
                .willReturn(account);
        // when
        AccountResponse accountResponse = accountApi.getAccount(accountId1.getValue());
        // then
        verify(accountDomainService, times(1))
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
        verify(accountDomainService, times(1))
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
        verify(accountDomainService, times(1))
                .decreaseBalance(decreaseBalanceCommandCaptor.capture());
        DecreaseBalanceCommand decreaseBalanceCommand = decreaseBalanceCommandCaptor.getValue();
        assertAll(
                () -> assertEquals(accountId1, decreaseBalanceCommand.id()),
                () -> assertEquals(money, decreaseBalanceCommand.amount())
        );
    }

}
