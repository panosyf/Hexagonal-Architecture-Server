package com.hexagonal.server.transaction.application.service.apis.exposed;

import com.hexagonal.server.transaction.application.service.model.requests.TransactionCreateRequest;
import com.hexagonal.server.transaction.application.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.transaction.application.service.model.responses.TransactionCreationResponse;
import com.hexagonal.server.transaction.application.service.model.responses.TransactionResponse;
import com.hexagonal.server.transaction.application.service.model.responses.TransactionUpdateResponse;

public interface TransactionApi {

    TransactionResponse getTransaction(String id);

    TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest);

    TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest);

}
