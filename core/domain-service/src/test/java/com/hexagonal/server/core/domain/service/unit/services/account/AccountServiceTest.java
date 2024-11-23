package com.hexagonal.server.core.domain.service.unit.services.account;

import com.hexagonal.server.core.domain.domains.account.Account;
import com.hexagonal.server.core.domain.exceptions.elementnotfound.AccountNotFoundException;
import com.hexagonal.server.core.domain.exceptions.utils.messages.ErrorMessageConstants;
import com.hexagonal.server.core.domain.service.common.constants.*;
import com.hexagonal.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.server.core.domain.service.model.commands.DecreaseBalanceCommand;
import com.hexagonal.server.core.domain.service.model.commands.GetAccountCommand;
import com.hexagonal.server.core.domain.service.model.commands.IncreaseBalanceCommand;
import com.hexagonal.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.server.core.domain.service.services.account.AccountService;
import com.hexagonal.server.core.domain.service.services.account.AccountServiceImpl;
import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.shared.kernel.common.valueobjects.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;

import static com.hexagonal.server.core.domain.service.common.mocks.AccountMocks.generateAccount;
import static com.hexagonal.server.core.domain.service.common.mocks.CreateAccountCommandMocks.generateCreateAccountCommand;
import static com.hexagonal.server.core.domain.service.common.mocks.DecreaseBalanceCommandMocks.generateDecreaseBalanceCommand;
import static com.hexagonal.server.core.domain.service.common.mocks.GetAccountCommandMocks.generateGetAccountCommand;
import static com.hexagonal.server.core.domain.service.common.mocks.IncreaseBalanceCommandMocks.generateIncreaseBalanceCommand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    private final AccountRepositoryPort accountRepositoryPort = mock(AccountRepositoryPort.class);
    private AccountService accountService;
    private final ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
    private static final Money BALANCE_0 = Money.zero();
    private static final Money BALANCE_5 = Money.of(BigDecimal.valueOf(5));
    private static final Money BALANCE_10 = Money.of(BigDecimal.TEN);
    private static final Money BALANCE_15 = Money.of(BigDecimal.valueOf(15));

    @BeforeEach
    void init() {
        accountService = new AccountServiceImpl(accountRepositoryPort);
    }

    @Test
    void getAccountTest() {
        // given
        GetAccountCommand getAccountCommand = generateGetAccountCommand();
        Account account = generateAccount();
        given(accountRepositoryPort.findById(any(Id.class)))
                .willReturn(account);
        // when
        Account accountResult = accountService.getAccount(getAccountCommand);
        // then
        assertAll(
                () -> assertEquals(Emails.EMAIL_1, accountResult.getEmail()),
                () -> assertEquals(Usernames.USERNAME_1, accountResult.getUsername()),
                () -> assertEquals(Passwords.PASSWORD_1, accountResult.getPassword()),
                () -> assertEquals(Names.ACCOUNT_NAME_1, accountResult.getName()),
                () -> assertEquals(BALANCE_0, accountResult.getBalance()),
                () -> assertEquals(account.getCreatedAt(), accountResult.getCreatedAt()),
                () -> assertEquals(account.getUpdatedAt(), accountResult.getUpdatedAt())
        );
    }

    @Test
    void getAccountThrowsAccountNotFoundExceptionTest() {
        // given
        GetAccountCommand getAccountCommand = generateGetAccountCommand();
        given(accountRepositoryPort.findById(any(Id.class)))
                .willThrow(new AccountNotFoundException(Ids.ACCOUNT_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> accountService.getAccount(getAccountCommand))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessage(ErrorUtils.generateErrorMessage(ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION, Ids.ACCOUNT_ID_1.getValue()));
    }

    @Test
    void createAccountTest() {
        // given
        CreateAccountCommand createAccountCommand = generateCreateAccountCommand();
        Timestamp timestampBeforeAccountCreation = Timestamp.now().minusNanos(100);
        Account account = generateAccount();
        given(accountRepositoryPort.save(any(Account.class)))
                .willReturn(account);
        // when
        accountService.createAccount(createAccountCommand);
        // then
        verify(accountRepositoryPort, times(1))
                .save(accountCaptor.capture());
        Account persistedAccount = accountCaptor.getValue();
        assertAll(
                () -> assertEquals(Emails.EMAIL_1, persistedAccount.getEmail()),
                () -> assertEquals(Usernames.USERNAME_1, persistedAccount.getUsername()),
                () -> assertEquals(Passwords.PASSWORD_1, persistedAccount.getPassword()),
                () -> assertEquals(Names.ACCOUNT_NAME_1, persistedAccount.getName()),
                () -> assertEquals(BALANCE_0, persistedAccount.getBalance()),
                () -> assertThat(timestampBeforeAccountCreation.isBefore(persistedAccount.getCreatedAt())).isTrue(),
                () -> assertThat(timestampBeforeAccountCreation.isBefore(persistedAccount.getUpdatedAt())).isTrue()
        );
    }

    @Test
    void increaseBalanceTest() {
        // given
        IncreaseBalanceCommand increaseBalanceCommand = generateIncreaseBalanceCommand();
        Account account = generateAccount();
        given(accountRepositoryPort.findById(any(Id.class)))
                .willReturn(account);
        // when
        accountService.increaseBalance(increaseBalanceCommand);
        // then
        verify(accountRepositoryPort, times(1))
                .updateBalance(accountCaptor.capture());
        assertThat(accountCaptor.getValue().getBalance()).isEqualTo(BALANCE_10);
    }

    @Test
    void increaseBalanceThrowsAccountNotFoundExceptionTest() {
        // given
        IncreaseBalanceCommand increaseBalanceCommand = generateIncreaseBalanceCommand();
        given(accountRepositoryPort.findById(any(Id.class)))
                .willThrow(new AccountNotFoundException(Ids.ACCOUNT_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> accountService.increaseBalance(increaseBalanceCommand))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessage(ErrorUtils.generateErrorMessage(ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION, Ids.ACCOUNT_ID_1.getValue()));
    }

    @Test
    void decreaseBalanceTest() {
        // given
        DecreaseBalanceCommand decreaseBalanceCommand = generateDecreaseBalanceCommand();
        Account account = generateAccount(BALANCE_15);
        given(accountRepositoryPort.findById(any(Id.class)))
                .willReturn(account);
        // when
        accountService.decreaseBalance(decreaseBalanceCommand);
        // then
        verify(accountRepositoryPort, times(1))
                .updateBalance(accountCaptor.capture());
        assertThat(accountCaptor.getValue().getBalance()).isEqualTo(BALANCE_5);
    }

    @Test
    void decreaseBalanceTestThrowsAccountNotFoundExceptionTest() {
        // given
        DecreaseBalanceCommand decreaseBalanceCommand = generateDecreaseBalanceCommand();
        given(accountRepositoryPort.findById(any(Id.class)))
                .willThrow(new AccountNotFoundException(Ids.ACCOUNT_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> accountService.decreaseBalance(decreaseBalanceCommand))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessage(ErrorUtils.generateErrorMessage(ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION, Ids.ACCOUNT_ID_1.getValue()));
    }

}
