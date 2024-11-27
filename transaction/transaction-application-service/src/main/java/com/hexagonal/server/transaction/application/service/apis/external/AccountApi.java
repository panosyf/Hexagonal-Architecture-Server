package com.hexagonal.server.transaction.application.service.apis.external;


import java.math.BigDecimal;

public interface AccountApi {

    void increaseBalance(String id, BigDecimal amount);

    void decreaseBalance(String id, BigDecimal amount);

}