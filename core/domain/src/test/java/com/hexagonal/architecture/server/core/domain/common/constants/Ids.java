package com.hexagonal.architecture.server.core.domain.common.constants;

import com.hexagonal.architecture.server.core.domain.valueobjects.Id;

public class Ids {

    private Ids() {
    }

    public static final Id ACCOUNT_ID_1 = Id.generate("accountId1");
    public static final Id ACCOUNT_ID_2 = Id.generate("accountId2");
    public static final Id TRANSACTION_ID_1 = Id.generate("transactionId1");
    public static final Id TRANSACTION_ID_2 = Id.generate("transactionId2");

}
