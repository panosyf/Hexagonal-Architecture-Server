package com.hexagonal.server.infra.common.mocks.transaction;

import com.hexagonal.server.account.application.service.model.requests.transaction.TransactionCreateRequest;
import com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionType;
import com.hexagonal.server.infra.common.constants.transaction.Ids;
import com.hexagonal.server.shared.kernel.common.valueobjects.Description;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;

import java.math.BigDecimal;

public class TransactionCreateRequestMocks {

    private TransactionCreateRequestMocks() {
    }

    public static TransactionCreateRequest generateTransactionCreateRequest() {
        return new TransactionCreateRequest(
                TransactionType.TRANSFER,
                Money.of(BigDecimal.valueOf(5)).getValue(),
                Description.emptyDescription().getValue(),
                Ids.ACCOUNT_ID_1.getValue(),
                Ids.ACCOUNT_ID_2.getValue());
    }

    public static TransactionCreateRequest generateTransactionCreateRequest(String debtorAccountId, String beneficiaryAccountId) {
        return new TransactionCreateRequest(
                TransactionType.TRANSFER,
                Money.of(BigDecimal.valueOf(5)).getValue(),
                Description.emptyDescription().getValue(),
                debtorAccountId,
                beneficiaryAccountId);
    }

}
