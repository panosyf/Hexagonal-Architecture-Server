package com.hexagonal.server.transaction.application.service.common.mocks;

import com.hexagonal.server.transaction.application.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;

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
