package com.hexagonal.architecture.server.integration.test.suite.common.mocks;

import com.hexagonal.architecture.server.integration.test.suite.common.constants.Id;
import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;
import com.hexagonal.architecture.server.core.domain.model.constants.Amount;

public class TransactionMocks {

    private TransactionMocks() {
    }

    public static Transaction generateTransaction() {
        return new Transaction(
                TransactionType.TRANSFER,
                Amount.AMOUNT_5,
                "",
                Id.ACCOUNT_ID_1,
                Id.ACCOUNT_ID_2,
                TransactionStatusEnum.CREATED);
    }

    public static Transaction generateTransaction(String id) {
        return new Transaction(
                id,
                TransactionType.TRANSFER,
                Amount.AMOUNT_5,
                "",
                Id.ACCOUNT_ID_1,
                Id.ACCOUNT_ID_2,
                TransactionStatusEnum.CREATED);
    }

    public static Transaction generatePendingTransaction(String id) {
        Transaction transaction = generateTransaction(id);
        transaction.updateStatus(TransactionStatusEnum.PENDING);
        return transaction;
    }

}
