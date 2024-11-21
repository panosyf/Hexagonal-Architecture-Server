package com.hexagonal.server.api.common.constants;

import com.hexagonal.server.shared.kernel.valueobjects.Username;

public class Usernames {

    private Usernames() {
    }

    public static final Username USERNAME_1 = Username.valueOf("username1");
    public static final Username USERNAME_2 = Username.valueOf("username2");

}