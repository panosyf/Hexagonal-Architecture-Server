package com.hexagonal.architecture.server.core.domain.service.unit.services.account;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.exceptions.elementnotfound.AccountNotFoundException;
import com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants;
import com.hexagonal.architecture.server.core.domain.model.constants.Amount;
import com.hexagonal.architecture.server.core.domain.model.constants.Balance;
import com.hexagonal.architecture.server.core.domain.service.common.constants.Ids;
import com.hexagonal.architecture.server.core.domain.service.common.constants.Names;
import com.hexagonal.architecture.server.core.domain.service.model.commands.CreateAccountCommand;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.AccountRepositoryPort;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import com.hexagonal.architecture.server.core.domain.service.services.account.AccountServiceImpl;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static com.hexagonal.architecture.server.core.domain.exceptions.utils.ErrorUtils.generateErrorMessage;
import static com.hexagonal.architecture.server.core.domain.service.common.mocks.AccountMocks.generateAccount;
import static com.hexagonal.architecture.server.core.domain.service.common.mocks.CreateAccountCommandMocks.generateCreateAccountCommand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    private final AccountRepositoryPort accountRepositoryPort = mock(AccountRepositoryPort.class);
    private AccountService accountService;
    private final ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);

    @BeforeEach
    void init() {
        accountService = new AccountServiceImpl(accountRepositoryPort);
    }

    @Test
    void getAccountTest() {
        // given
        Account account = generateAccount();
        given(accountRepositoryPort.findById(any(Id.class)))
                .willReturn(account);
        // when
        Account accountResult = accountService.getAccount(Ids.ACCOUNT_ID_1);
        // then
        assertAll(
                () -> assertEquals(Names.ACCOUNT_NAME_1, accountResult.getName()),
                () -> assertEquals(Balance.BALANCE_0, accountResult.getBalance()),
                () -> assertEquals(account.getCreatedAt(), accountResult.getCreatedAt()),
                () -> assertEquals(account.getUpdatedAt(), accountResult.getUpdatedAt())
        );
    }

    @Test
    void getAccountThrowsAccountNotFoundExceptionTest() {
        // given
        given(accountRepositoryPort.findById(any(Id.class)))
                .willThrow(new AccountNotFoundException(Ids.ACCOUNT_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> accountService.getAccount(Ids.ACCOUNT_ID_1))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessage(generateErrorMessage(ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION, Ids.ACCOUNT_ID_1.getValue()));
    }

    @Test
    void createAccountTest() {
        // given
        CreateAccountCommand createAccountCommand = generateCreateAccountCommand();
        Timestamp timestampBeforeAccountCreation = Timestamp.now().minusNanos(100);
        given(accountRepositoryPort.save(any(Account.class)))
                .willReturn(generateAccount());
        // when
        accountService.createAccount(createAccountCommand);
        // then
        verify(accountRepositoryPort, times(1))
                .save(accountCaptor.capture());
        Account account = accountCaptor.getValue();
        assertAll(
                () -> assertEquals(Names.ACCOUNT_NAME_1, account.getName()),
                () -> assertEquals(Balance.BALANCE_0, account.getBalance()),
                () -> assertThat(timestampBeforeAccountCreation.isBefore(account.getCreatedAt())).isTrue(),
                () -> assertThat(timestampBeforeAccountCreation.isBefore(account.getUpdatedAt())).isTrue()
        );
    }

    @Test
    void increaseBalanceTest() {
        // given
        Account account = generateAccount();
        given(accountRepositoryPort.findById(any(Id.class)))
                .willReturn(account);
        // when
        accountService.increaseBalance(Ids.ACCOUNT_ID_1, Amount.AMOUNT_10);
        // then
        verify(accountRepositoryPort, times(1))
                .updateBalance(accountCaptor.capture());
        assertThat(accountCaptor.getValue().getBalance()).isEqualTo(Balance.BALANCE_10);
    }

    @Test
    void increaseBalanceThrowsAccountNotFoundExceptionTest() {
        // given
        given(accountRepositoryPort.findById(any(Id.class)))
                .willThrow(new AccountNotFoundException(Ids.ACCOUNT_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> accountService.increaseBalance(Ids.ACCOUNT_ID_1, Amount.AMOUNT_10))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessage(generateErrorMessage(ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION, Ids.ACCOUNT_ID_1.getValue()));
    }

    @Test
    void decreaseBalanceTest() {
        // given
        Account account = generateAccount(Balance.BALANCE_15);
        given(accountRepositoryPort.findById(any(Id.class)))
                .willReturn(account);
        // when
        accountService.decreaseBalance(Ids.ACCOUNT_ID_1, Amount.AMOUNT_10);
        // then
        verify(accountRepositoryPort, times(1))
                .updateBalance(accountCaptor.capture());
        assertThat(accountCaptor.getValue().getBalance()).isEqualTo(Balance.BALANCE_5);
    }

    @Test
    void decreaseBalanceTestThrowsAccountNotFoundExceptionTest() {
        // given
        given(accountRepositoryPort.findById(any(Id.class)))
                .willThrow(new AccountNotFoundException(Ids.ACCOUNT_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> accountService.decreaseBalance(Ids.ACCOUNT_ID_1, Amount.AMOUNT_10))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessage(generateErrorMessage(ErrorMessageConstants.ACCOUNT_NOT_FOUND_EXCEPTION, Ids.ACCOUNT_ID_1.getValue()));
    }


}
