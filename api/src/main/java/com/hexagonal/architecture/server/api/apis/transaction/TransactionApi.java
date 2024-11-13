package com.hexagonal.architecture.server.api.apis.transaction;

import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;
import com.hexagonal.architecture.server.api.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.api.model.requests.TransactionUpdateRequest;

public interface TransactionApi {

    TransactionResponse getTransaction(String id);

    TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest);

    TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest);

}
