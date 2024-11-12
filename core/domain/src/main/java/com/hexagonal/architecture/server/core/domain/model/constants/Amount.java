package com.hexagonal.architecture.server.core.domain.model.constants;

import com.hexagonal.architecture.server.core.domain.valueobjects.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Amount {

    private Amount() {
    }

    public static final Money AMOUNT_0 = Money.zero();
    public static final Money AMOUNT_1 = Money.of(BigDecimal.ONE);
    public static final Money AMOUNT_2 = Money.of(BigDecimal.TWO);
    public static final Money AMOUNT_5 = Money.of(BigDecimal.valueOf(5));
    public static final Money AMOUNT_10 =Money.of( BigDecimal.TEN);
    public static final Money AMOUNT_15 =Money.of( BigDecimal.valueOf(15));
    public static final Money AMOUNT_20 =Money.of( BigDecimal.valueOf(20));

}
