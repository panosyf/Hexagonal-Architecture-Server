package com.hexagonal.server.application.service.common.mocks;

import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.application.service.model.requests.TransactionUpdateRequest;

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
