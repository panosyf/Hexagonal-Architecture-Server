package com.hexagonal.architecture.server.api.facades.transaction;

import com.hexagonal.architecture.server.api.model.dtos.TransactionDto;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;

public interface TransactionFacade {

    TransactionDto getTransaction(String id);

    TransactionCreationResponse createTransaction(TransactionCreateRequest transactionCreateRequest);

    TransactionUpdateResponse updateTransaction(String id, TransactionUpdateRequest transactionUpdateRequest);

}
