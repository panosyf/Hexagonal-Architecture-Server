package com.hexagonal.architecture.server.infra.common.mocks;

import com.hexagonal.architecture.server.api.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.model.constants.Amount;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;
import com.hexagonal.architecture.server.core.domain.valueobjects.Description;
import com.hexagonal.architecture.server.infra.common.constants.Ids;

public class TransactionCreateRequestMocks {

    private TransactionCreateRequestMocks() {
    }

    public static TransactionCreateRequest generateTransactionCreateRequest() {
        return new TransactionCreateRequest(
                TransactionType.TRANSFER,
                Amount.AMOUNT_5.getValue(),
                Description.emptyDescription().getValue(),
                Ids.ACCOUNT_ID_1.getValue(),
                Ids.ACCOUNT_ID_2.getValue());
    }

    public static TransactionCreateRequest generateTransactionCreateRequest(String debtorAccountId, String beneficiaryAccountId) {
        return new TransactionCreateRequest(
                TransactionType.TRANSFER,
                Amount.AMOUNT_5.getValue(),
                Description.emptyDescription().getValue(),
                debtorAccountId,
                beneficiaryAccountId);
    }

}
