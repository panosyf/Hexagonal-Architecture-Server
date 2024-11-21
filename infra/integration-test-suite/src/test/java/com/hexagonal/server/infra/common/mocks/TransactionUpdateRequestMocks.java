package com.hexagonal.server.infra.common.mocks;

import com.hexagonal.server.api.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum;

public class TransactionUpdateRequestMocks {

    private TransactionUpdateRequestMocks() {
    }

    public static TransactionUpdateRequest generateTransactionUpdateRequest() {
        return new TransactionUpdateRequest(TransactionStatusEnum.COMPLETED);
    }

    public static TransactionUpdateRequest generateTransactionUpdateRequest(TransactionStatusEnum transactionStatusEnum) {
        return new TransactionUpdateRequest(transactionStatusEnum);
    }

}
