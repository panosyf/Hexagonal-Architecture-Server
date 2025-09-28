package com.hexagonal.server.application.service.apis.transaction;

import com.hexagonal.server.application.service.model.responses.transaction.TransactionCreationResponse;
import com.hexagonal.server.application.service.model.responses.transaction.TransactionResponse;
import com.hexagonal.server.application.service.model.responses.transaction.TransactionUpdateResponse;
import com.hexagonal.server.application.service.model.requests.transaction.TransactionCreateRequest;
import com.hexagonal.server.application.service.model.requests.transaction.TransactionUpdateRequest;

public interface TransactionApi {

    TransactionResponse getTransaction(String id);

    TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest);

    TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest);

}
