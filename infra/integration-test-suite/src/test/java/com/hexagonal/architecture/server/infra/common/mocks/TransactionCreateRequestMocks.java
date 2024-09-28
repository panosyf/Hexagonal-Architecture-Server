package com.hexagonal.architecture.server.infra.common.mocks;

import com.hexagonal.architecture.server.infra.common.constants.Ids;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;
import com.hexagonal.architecture.server.core.domain.model.constants.Amount;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;

public class TransactionCreateRequestMocks {

    private TransactionCreateRequestMocks() {
    }

    public static TransactionCreateRequest generateTransactionCreateRequest() {
        return new TransactionCreateRequest(
                TransactionType.TRANSFER,
                Amount.AMOUNT_5,
                "",
                Ids.ACCOUNT_ID_1,
                Ids.ACCOUNT_ID_2);
    }

    public static TransactionCreateRequest generateTransactionCreateRequest(String debtorAccountId, String beneficiaryAccountId) {
        return new TransactionCreateRequest(
                TransactionType.TRANSFER,
                Amount.AMOUNT_5,
                "",
                debtorAccountId,
                beneficiaryAccountId);
    }

}
