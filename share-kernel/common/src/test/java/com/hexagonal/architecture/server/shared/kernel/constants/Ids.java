package com.hexagonal.architecture.server.shared.kernel.constants;

import com.hexagonal.architecture.server.shared.kernel.valueobjects.Id;

public class Ids {

    private Ids() {
    }

    public static final Id ACCOUNT_ID_1 = Id.valueOf("accountId1");
    public static final Id ACCOUNT_ID_2 = Id.valueOf("accountId2");
    public static final Id TRANSACTION_ID_1 = Id.valueOf("transactionId1");
    public static final Id TRANSACTION_ID_2 = Id.valueOf("transactionId2");

}
