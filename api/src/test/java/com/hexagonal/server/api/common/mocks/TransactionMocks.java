package com.hexagonal.server.api.common.mocks;

import com.hexagonal.server.api.common.constants.Ids;
import com.hexagonal.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.server.core.domain.model.enums.TransactionType;
import com.hexagonal.server.shared.kernel.valueobjects.Description;
import com.hexagonal.server.shared.kernel.valueobjects.Id;
import com.hexagonal.server.shared.kernel.valueobjects.Money;

import java.math.BigDecimal;

public class TransactionMocks {

    private TransactionMocks() {
    }

    public static Transaction generateTransaction() {
        return new Transaction(
                TransactionType.TRANSFER,
                Money.of(BigDecimal.valueOf(5)),
                Description.emptyDescription(),
                Ids.ACCOUNT_ID_1,
                Ids.ACCOUNT_ID_2,
                TransactionStatusEnum.PENDING);
    }

    public static Transaction generateTransaction(Id id) {
        return new Transaction(
                id,
                TransactionType.TRANSFER,
                Money.of(BigDecimal.valueOf(5)),
                Description.emptyDescription(),
                Ids.ACCOUNT_ID_1,
                Ids.ACCOUNT_ID_2,
                TransactionStatusEnum.PENDING);
    }

    public static Transaction generatePendingTransaction(Id id) {
        Transaction transaction = generateTransaction(id);
        transaction.updateStatus(TransactionStatusEnum.PENDING);
        return transaction;
    }

}