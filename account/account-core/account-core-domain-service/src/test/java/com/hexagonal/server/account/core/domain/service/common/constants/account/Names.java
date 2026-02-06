package com.hexagonal.server.account.core.domain.service.common.constants.account;

import com.hexagonal.server.shared.kernel.common.valueobjects.Name;

public class Names {

    private Names() {
    }

    public static final Name ACCOUNT_NAME_1 = Name.valueOf("accountName1", "accountSurname1");
    public static final Name ACCOUNT_NAME_2 = Name.valueOf("accountName2", "accountSurname2");

}
