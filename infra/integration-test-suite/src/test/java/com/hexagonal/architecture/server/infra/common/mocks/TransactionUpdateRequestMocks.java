package com.hexagonal.architecture.server.infra.common.mocks;

import com.hexagonal.architecture.server.api.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;

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
