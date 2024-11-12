package com.hexagonal.architecture.server.core.domain.model.constants;

import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

import java.math.BigDecimal;

public class Balance {

    private Balance() {
    }

    public static final Money BALANCE_0 = Money.zero();
    public static final Money BALANCE_1 = Money.of(BigDecimal.ONE);
    public static final Money BALANCE_2 = Money.of(BigDecimal.TWO);
    public static final Money BALANCE_5 = Money.of(BigDecimal.valueOf(5));
    public static final Money BALANCE_10 = Money.of(BigDecimal.TEN);
    public static final Money BALANCE_15 = Money.of(BigDecimal.valueOf(15));
    public static final Money BALANCE_20 = Money.of(BigDecimal.valueOf(20));

}
