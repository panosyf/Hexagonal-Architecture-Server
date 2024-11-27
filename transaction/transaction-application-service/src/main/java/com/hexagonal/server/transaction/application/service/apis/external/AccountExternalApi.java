package com.hexagonal.server.transaction.application.service.apis.external;

import java.math.BigDecimal;

public interface AccountExternalApi {

    void increaseBalance(String id, BigDecimal amount);

    void decreaseBalance(String id, BigDecimal amount);

}
