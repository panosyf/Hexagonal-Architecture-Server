package com.hexagonal.server.infra.common.mocks.transaction;

import com.hexagonal.server.application.service.model.requests.transaction.TransactionUpdateRequest;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;

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
