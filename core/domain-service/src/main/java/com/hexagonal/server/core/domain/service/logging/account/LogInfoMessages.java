package com.hexagonal.server.core.domain.service.logging.account;

public class LogInfoMessages {

    private LogInfoMessages() {
    }

    public static final String LOG_ACCOUNT_CREATED_INFO = "Account created for email: {} and username: {}";
    public static final String LOG_BALANCE_INCREASED_FOR_ACCOUNT = "Balance increased for account with id: {}";
    public static final String LOG_BALANCE_DECREASED_FOR_ACCOUNT = "Balance decreased for account with id: {}";

}
