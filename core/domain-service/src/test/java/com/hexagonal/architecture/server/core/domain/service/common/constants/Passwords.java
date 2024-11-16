package com.hexagonal.architecture.server.core.domain.service.common.constants;

import com.hexagonal.architecture.server.core.domain.valueobjects.Password;

public class Passwords {

    private Passwords() {
    }

    public static final Password PASSWORD_1 = Password.valueOf("password1");
    public static final Password PASSWORD_2 = Password.valueOf("password2");

}
