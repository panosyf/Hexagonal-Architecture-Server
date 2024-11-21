package com.hexagonal.server.core.domain.common.constants;

import com.hexagonal.server.shared.kernel.valueobjects.Password;

public class Passwords {

    private Passwords() {
    }

    public static final Password PASSWORD_1 = Password.valueOf("password1");
    public static final Password PASSWORD_2 = Password.valueOf("password2");

}
