package com.hexagonal.server.account.infra.common.mocks;

import com.hexagonal.server.account.application.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.account.core.domain.enums.TransactionStatusEnum;

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
