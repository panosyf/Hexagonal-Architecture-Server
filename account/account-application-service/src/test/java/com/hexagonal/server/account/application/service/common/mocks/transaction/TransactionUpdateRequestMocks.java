package com.hexagonal.server.account.application.service.common.mocks.transaction;

import com.hexagonal.server.account.application.service.model.requests.transaction.TransactionUpdateRequest;
import com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionStatusEnum;

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
