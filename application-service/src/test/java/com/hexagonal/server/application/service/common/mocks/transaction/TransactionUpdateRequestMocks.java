package com.hexagonal.server.application.service.common.mocks.transaction;

import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.application.service.model.requests.transaction.TransactionUpdateRequest;

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
