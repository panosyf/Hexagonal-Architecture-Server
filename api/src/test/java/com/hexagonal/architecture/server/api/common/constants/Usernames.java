package com.hexagonal.architecture.server.api.common.constants;

import com.hexagonal.architecture.server.core.domain.valueobjects.Username;

public class Usernames {

    private Usernames() {
    }

    public static final Username USERNAME_1 = Username.valueOf("username1");
    public static final Username USERNAME_2 = Username.valueOf("username2");

}
