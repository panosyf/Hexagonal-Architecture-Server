package com.hexagonal.server.common.mocks;

import com.hexagonal.server.shared.kernel.common.valueobjects.Description;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.transaction.application.service.model.requests.TransactionCreateRequest;
import com.hexagonal.server.transaction.core.domain.enums.TransactionType;
import com.hexagonal.server.transaction.infra.common.constants.Ids;

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
