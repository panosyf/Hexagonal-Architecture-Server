package com.hexagonal.server.account.application.apis.transaction;

import com.hexagonal.server.account.application.model.requests.transaction.TransactionCreateRequest;
import com.hexagonal.server.account.application.model.requests.transaction.TransactionUpdateRequest;
import com.hexagonal.server.account.application.model.responses.transaction.TransactionCreationResponse;
import com.hexagonal.server.account.application.model.responses.transaction.TransactionResponse;
import com.hexagonal.server.account.application.model.responses.transaction.TransactionUpdateResponse;

public interface TransactionApi {

    TransactionResponse getTransaction(String id);

    TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest);

    TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest);

}
