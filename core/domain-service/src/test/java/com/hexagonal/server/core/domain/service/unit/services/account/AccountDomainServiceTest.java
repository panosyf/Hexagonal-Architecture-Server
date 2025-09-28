package com.hexagonal.server.core.domain.service.unit.services.account;

import com.hexagonal.server.core.domain.entities.account.Account;
import com.hexagonal.server.core.domain.exceptions.elementnotfound.account.AccountNotFoundException;
import com.hexagonal.server.core.domain.service.common.constants.account.Emails;
import com.hexagonal.server.core.domain.service.common.constants.account.Names;
import com.hexagonal.server.core.domain.service.common.constants.account.Passwords;
import com.hexagonal.server.core.domain.service.common.constants.account.Usernames;
import com.hexagonal.server.core.domain.service.common.constants.account.Ids;
import com.hexagonal.server.core.domain.service.logic.account.AccountDomainService;
import com.hexagonal.server.core.domain.service.logic.account.AccountDomainServiceImpl;
import com.hexagonal.server.core.domain.service.model.commands.account.CreateAccountCommand;
import com.hexagonal.server.core.domain.service.model.commands.account.DecreaseBalanceCommand;
import com.hexagonal.server.core.domain.service.model.commands.account.GetAccountCommand;
import com.hexagonal.server.core.domain.service.model.commands.account.IncreaseBalanceCommand;
import com.hexagonal.server.core.domain.service.ports.driven.account.AccountRepositoryPort;
import com.hexagonal.server.shared.kernel.common.exception.constants.ErrorMessageConstants;
import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.shared.kernel.common.valueobjects.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;

import static com.hexagonal.server.core.domain.service.common.mocks.account.AccountMocks.generateAccount;
import static com.hexagonal.server.core.domain.service.common.mocks.account.CreateAccountCommandMocks.generateCreateAccountCommand;
import static com.hexagonal.server.core.domain.service.common.mocks.account.DecreaseBalanceCommandMocks.generateDecreaseBalanceCommand;
import static com.hexagonal.server.core.domain.service.common.mocks.account.GetAccountCommandMocks.generateGetAccountCommand;
import static com.hexagonal.server.core.domain.service.common.mocks.account.IncreaseBalanceCommandMocks.generateIncreaseBalanceCommand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AccountDomainServiceTest {

    private final AccountRepositoryPort accountRepositoryPort = mock(AccountRepositoryPort.class);
    private AccountDomainService accountDomainService;
    private final ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
    private static final Money BALANCE_0 = Money.zero();
    private static final Money BALANCE_5 = Money.of(BigDecimal.valueOf(5));
    private static final Money BALANCE_10 = Money.of(BigDecimal.TEN);
    private static final Money BALANCE_15 = Money.of(BigDecimal.valueOf(15));

    @BeforeEach
    void init() {
        accountDomainService = new AccountDomainServiceImpl(accountRepositoryPort);
    }

    @Test
    void getAccountTest() {
        // given
        GetAccountCommand getAccountCommand = generateGetAccountCommand();
        Account account = generateAccount();
        given(accountRepositoryPort.findById(any(Id.class)))
                .willReturn(account);
        // when
        Account accountResult = accountDomainService.getAccount(getAccountCommand);
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
        assertThatThrownBy(() -> accountDomainService.getAccount(getAccountCommand))
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
        accountDomainService.createAccount(createAccountCommand);
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
        accountDomainService.increaseBalance(increaseBalanceCommand);
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
        assertThatThrownBy(() -> accountDomainService.increaseBalance(increaseBalanceCommand))
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
        accountDomainService.decreaseBalance(decreaseBalanceCommand);
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
        assertThatThrownBy(() -> accountDomainService.decreaseBalance(decreaseBalanceCommand))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessage(ErrorUtils.generateErrorMessage(ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION, Ids.ACCOUNT_ID_1.getValue()));
    }

}
