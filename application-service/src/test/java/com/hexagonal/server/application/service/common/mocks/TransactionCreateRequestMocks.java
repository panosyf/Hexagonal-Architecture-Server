package com.hexagonal.server.application.service.common.mocks;

import com.hexagonal.server.core.domain.model.enums.TransactionType;
import com.hexagonal.server.application.service.common.constants.Ids;
import com.hexagonal.server.application.service.model.requests.TransactionCreateRequest;
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
