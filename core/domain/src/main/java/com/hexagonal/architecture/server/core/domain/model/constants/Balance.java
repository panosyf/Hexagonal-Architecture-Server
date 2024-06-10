package com.hexagonal.architecture.server.core.domain.model.constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Balance {

    private Balance() {
    }

    public static final BigDecimal BALANCE_0 = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal BALANCE_1 = BigDecimal.ONE.setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal BALANCE_2 = BigDecimal.TWO.setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal BALANCE_5 = BigDecimal.valueOf(5).setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal BALANCE_10 = BigDecimal.TEN.setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal BALANCE_15 = BigDecimal.valueOf(15).setScale(2, RoundingMode.HALF_UP);
    public static final BigDecimal BALANCE_20 = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_UP);

}
