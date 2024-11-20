package com.hexagonal.architecture.server.core.domain.exceptions.utils.messages;


public class ErrorMessageConstants {

    private ErrorMessageConstants() {
    }

    public static final String ACCOUNT_NOT_FOUND_EXCEPTION = "Account with id: %s not found";
    public static final String TRANSACTION_NOT_FOUND_EXCEPTION = "Transaction with id: %s not found";
    public static final String INSUFFICIENT_BALANCE_EXCEPTION = "Account with id: %s has insufficient balance";

}
