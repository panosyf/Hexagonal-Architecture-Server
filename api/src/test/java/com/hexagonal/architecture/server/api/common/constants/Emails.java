package com.hexagonal.architecture.server.api.common.constants;

import com.hexagonal.architecture.server.core.domain.valueobjects.Email;

public class Emails {

    private Emails() {
    }

    public static final Email EMAIL_1 = Email.valueOf("email1", "gmail", "com");
    public static final Email EMAIL_2 = Email.valueOf("email2", "gmail", "com");

}
