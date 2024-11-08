package com.hexagonal.architecture.server.core.domain.domains.account;

import com.hexagonal.architecture.server.core.domain.domains.DomainEntity;
import com.hexagonal.architecture.server.core.domain.exceptions.illegalargument.InsufficientBalanceException;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import static com.hexagonal.architecture.server.core.domain.model.constants.Balance.BALANCE_0;
import static com.hexagonal.architecture.server.core.domain.utils.TimeUtils.now;

public class Account extends DomainEntity {

    private String id;
    private String name;
    private BigDecimal balance;
    private Instant createdAt;
    private Instant updatedAt;

    private Account() {
    }

    public Account(final String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.balance = BALANCE_0;
        this.createdAt = now();
        this.updatedAt = null;
    }

    public Account(final String name, final BigDecimal balance) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.balance = balance;
        this.createdAt = now();
        this.updatedAt = null;
    }

    public Account(final String id, final String name, final BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.createdAt = now();
        this.updatedAt = null;
    }

    public Account(
            final String id,
            final String name,
            final BigDecimal balance,
            final Instant createdAt,
            final Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public boolean hasBalance() {
        return this.balance.compareTo(BALANCE_0) > 0;
    }

    public boolean isBalanceEligibleForTransaction(final BigDecimal transactionAmount) {
        return hasBalance() && balance.compareTo(transactionAmount) >= 0;
    }

    public boolean notEligibleBalanceForTransaction(final BigDecimal transactionAmount) {
        return !isBalanceEligibleForTransaction(transactionAmount);
    }

    public void validateBalanceEligibleForTransaction(final BigDecimal amount) {
        if (notEligibleBalanceForTransaction(amount)) {
            throw new InsufficientBalanceException(id);
        }
    }

    public void increaseBalance(final BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void decreaseBalance(final BigDecimal amount) {
        validateBalanceEligibleForTransaction(amount);
        this.balance = this.balance.subtract(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name) && Objects.equals(balance, account.balance) && Objects.equals(createdAt, account.createdAt) && Objects.equals(updatedAt, account.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
