package com.hexagonal.architecture.server.core.domain.common.constants;

import com.hexagonal.architecture.server.core.domain.valueobjects.Password;

public class Passwords {

    private Passwords() {
    }

    public static final Password PASSWORD_1 = Password.generate("password1");
    public static final Password PASSWORD_2 = Password.generate("password2");

}
