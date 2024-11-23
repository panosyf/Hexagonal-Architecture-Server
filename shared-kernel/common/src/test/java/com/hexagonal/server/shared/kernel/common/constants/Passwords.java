package com.hexagonal.server.shared.kernel.common.constants;

import com.hexagonal.server.shared.kernel.common.valueobjects.Password;

public class Passwords {

    private Passwords() {
    }

    public static final Password PASSWORD_1 = Password.valueOf("password1");
    public static final Password PASSWORD_2 = Password.valueOf("password2");

}
