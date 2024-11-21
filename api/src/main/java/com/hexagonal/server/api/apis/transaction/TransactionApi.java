package com.hexagonal.server.api.apis.transaction;

import com.hexagonal.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.server.api.model.responses.TransactionResponse;
import com.hexagonal.server.api.model.responses.TransactionUpdateResponse;
import com.hexagonal.server.api.model.requests.TransactionCreateRequest;
import com.hexagonal.server.api.model.requests.TransactionUpdateRequest;

public interface TransactionApi {

    TransactionResponse getTransaction(String id);

    TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest);

    TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest);

}