package com.hexagonal.architecture.server.core.domain.valueobjects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;

public class Money extends ValueObject {

    private final BigDecimal amount;
    private final Currency currency;
    public static final Money ZERO = new Money(BigDecimal.ZERO);

    private Money(BigDecimal amount) {
        this.amount = Money.setScale(amount);
        this.currency = Currency.getInstance("EUR");
    }

    public static Money of(BigDecimal amount) {
        return new Money(amount == null ? BigDecimal.ZERO : amount);
    }

    public static Money zero() {
        return ZERO;
    }

    private static BigDecimal setScale(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public Money add(final Money money) {
        return new Money(this.amount.add(money.amount));
    }

    public Money subtract(final Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money multiply(final int multiplier) {
        return new Money(this.amount.multiply(new BigDecimal(multiplier)));
    }

    public boolean isZero() {
        return this.amount.compareTo(BigDecimal.ZERO) == 0;
    }

    public boolean isGreaterThanZero() {
        return this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(final Money money) {
        return this.amount.compareTo(money.amount) > 0;
    }

    public boolean isLessThan(final Money money) {
        return this.amount.compareTo(money.amount) < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount) && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

}
