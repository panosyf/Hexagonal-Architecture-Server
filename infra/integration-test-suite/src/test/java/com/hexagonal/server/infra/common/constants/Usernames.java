package com.hexagonal.server.infra.common.constants;

import com.hexagonal.server.shared.kernel.common.valueobjects.Username;

public class Usernames {

    private Usernames() {
    }

    public static final Username USERNAME_1 = Username.valueOf("username1");
    public static final Username USERNAME_2 = Username.valueOf("username2");

}
