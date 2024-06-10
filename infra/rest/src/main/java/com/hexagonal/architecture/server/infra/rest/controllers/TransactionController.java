package com.hexagonal.architecture.server.infra.rest.controllers;

import com.hexagonal.architecture.server.api.facades.transaction.TransactionFacade;
import com.hexagonal.architecture.server.api.model.dtos.TransactionDto;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final TransactionFacade transactionFacade;

    public TransactionController(TransactionFacade transactionFacade) {
        this.transactionFacade = transactionFacade;
    }

    @GetMapping(path = "/api/v1/transactions/{id}")
    public ResponseEntity<TransactionDto> getTransaction(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(transactionFacade.getTransaction(id), HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/transactions")
    public ResponseEntity<TransactionCreationResponse> createTransaction(@RequestBody TransactionCreateRequest transactionCreateRequest) {
        return new ResponseEntity<>(transactionFacade.createTransaction(transactionCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/api/v1/transactions/{id}")
    public ResponseEntity<TransactionUpdateResponse> updateTransaction(
            @PathVariable(value = "id") String id,
            @RequestBody TransactionUpdateRequest transactionUpdateRequest) {
        return new ResponseEntity<>(transactionFacade.updateTransaction(id, transactionUpdateRequest), HttpStatus.OK);
    }

}
