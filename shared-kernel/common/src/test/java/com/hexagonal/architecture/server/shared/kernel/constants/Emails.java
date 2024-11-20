package com.hexagonal.architecture.server.shared.kernel.constants;

import com.hexagonal.architecture.server.shared.kernel.valueobjects.Email;

public class Emails {

    private Emails() {
    }

    public static final Email EMAIL_1 = Email.valueOf("email1", "gmail", "com");
    public static final Email EMAIL_2 = Email.valueOf("email2", "gmail", "com");

}
