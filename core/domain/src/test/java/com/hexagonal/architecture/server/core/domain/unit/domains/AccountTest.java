package com.hexagonal.architecture.server.core.domain.unit.domains;

import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.exceptions.baddata.InsufficientBalanceException;
import com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants;
import com.hexagonal.architecture.server.core.domain.model.constants.Amount;
import com.hexagonal.architecture.server.core.domain.model.constants.Balance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static com.hexagonal.architecture.server.core.domain.common.mocks.AccountMocks.generateAccount;
import static com.hexagonal.architecture.server.core.domain.exceptions.utils.ErrorUtils.generateErrorMessage;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    @Test
    void hasBalanceTest() {
        Account account = generateAccount(Balance.BALANCE_10);
        assertTrue(account.hasBalance());
    }

    @ParameterizedTest(name = "Account with balance {0} eligibility for transaction with amount {1} is {2}")
    @MethodSource("isBalanceEligibleForTransactionTestArguments")
    void isBalanceEligibleForTransactionTest(BigDecimal balance, BigDecimal amount, boolean result) {
        Account account = generateAccount(balance);
        assertThat(account.isBalanceEligibleForTransaction(amount)).isEqualTo(result);
    }

    private static Stream<Arguments> isBalanceEligibleForTransactionTestArguments() {
        return Stream.of(
                Arguments.of(Balance.BALANCE_5, Amount.AMOUNT_10, false),
                Arguments.of(Balance.BALANCE_0, Amount.AMOUNT_0, false),
                Arguments.of(Balance.BALANCE_5, Amount.AMOUNT_1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("notEligibleBalanceForTransactionTestArguments")
    void notEligibleBalanceForTransactionTest(BigDecimal balance, BigDecimal amount, boolean result) {
        Account account = generateAccount(balance);
        assertThat(account.notEligibleBalanceForTransaction(amount)).isEqualTo(result);
    }

    private static Stream<Arguments> notEligibleBalanceForTransactionTestArguments() {
        return Stream.of(
                Arguments.of(Balance.BALANCE_5, Amount.AMOUNT_10, true),
                Arguments.of(Balance.BALANCE_0, Amount.AMOUNT_0, true),
                Arguments.of(Balance.BALANCE_5, Amount.AMOUNT_1, false)
        );
    }

    @Test
    void validateBalanceEligibleForTransactionTest() {
        Account account = generateAccount();
        assertThatThrownBy(() -> account.validateBalanceEligibleForTransaction(Balance.BALANCE_10))
                .isInstanceOf(InsufficientBalanceException.class)
                .hasMessage(generateErrorMessage(ErrorMessageConstants.INSUFFICIENT_BALANCE_EXCEPTION, account.getId()));
    }

    @Test
    void increaseBalanceTest() {
        Account account = generateAccount(Balance.BALANCE_5);
        account.increaseBalance(Balance.BALANCE_15);
        assertThat(account.getBalance()).isEqualTo(Balance.BALANCE_20);
    }

    @Test
    void decreaseBalanceTest() {
        Account account = generateAccount(Balance.BALANCE_15);
        account.decreaseBalance(Balance.BALANCE_10);
        assertThat(account.getBalance()).isEqualTo(Balance.BALANCE_5);
    }

    @Test
    void decreaseBalanceThrowsInsufficientBalanceExceptionTest() {
        Account account = generateAccount(Balance.BALANCE_5);
        assertThatThrownBy(() -> account.decreaseBalance(Balance.BALANCE_10))
                .isInstanceOf(InsufficientBalanceException.class);
    }

}
