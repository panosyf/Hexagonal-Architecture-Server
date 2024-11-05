package com.hexagonal.architecture.server.core.domain.exceptions.utils.messages;


public class ErrorMessageConstants {

    private ErrorMessageConstants() {
    }

    public static final String ACCOUNT_NOT_FOUND_EXCEPTION = "Account with id: %s not found";
    public static final String TRANSACTION_NOT_FOUND_EXCEPTION = "Transaction with id: %s not found";
    public static final String INSUFFICIENT_BALANCE_EXCEPTION = "Account with id: %s has insufficient balance";
    public static final String EMAIL_VALUE_CANNOT_BE_NULL_OR_BLANK = "Email value cannot be null or blank";
    public static final String EMAIL_NAME_CANNOT_BE_NULL_OR_BLANK = "Email name cannot be null or blank";
    public static final String EMAIL_MAIL_SERVER_CANNOT_BE_NULL_OR_BLANK = "Email mail server cannot be null or blank";
    public static final String EMAIL_DOMAIN_CANNOT_BE_NULL_OR_BLANK = "Email domain cannot be null or blank";
    public static final String ID_CANNOT_BE_NULL_OR_BLANK = "Id cannot cannot be null or blank";
    public static final String FIRST_NAME_CANNOT_BE_NULL_OR_BLANK = "First name cannot be null or blank";
    public static final String LAST_NAME_ID_CANNOT_BE_NULL_OR_BLANK = "Last name cannot be null";
    public static final String PASSWORD_CANNOT_BE_NULL_OR_BLANK = "Password cannot be null or empty";
    public static final String TIMESTAMP_CANNOT_BE_NULL = "Timestamp cannot be null";
    public static final String VALUE_MUST_BE_AT_LEAST_ONE = "Value must be at least 1";
    public static final String USERNAME_ID_CANNOT_BE_NULL_OR_BLANK = "Username cannot be null or empty";

}
