package com.hexagonal.architecture.server.infra.rest.controllers;

import com.hexagonal.architecture.server.api.apis.transaction.TransactionApi;
import com.hexagonal.architecture.server.api.model.responses.TransactionResponse;
import com.hexagonal.architecture.server.api.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.api.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final TransactionApi transactionApi;

    public TransactionController(TransactionApi transactionApi) {
        this.transactionApi = transactionApi;
    }

    @GetMapping(path = "/api/v1/transactions/{id}")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(transactionApi.getTransaction(id), HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/transactions")
    public ResponseEntity<TransactionCreationResponse> createTransaction(@RequestBody TransactionCreateRequest transactionCreateRequest) {
        return new ResponseEntity<>(transactionApi.createTransaction(transactionCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/api/v1/transactions/{id}")
    public ResponseEntity<TransactionUpdateResponse> updateTransaction(
            @PathVariable(value = "id") String id,
            @RequestBody TransactionUpdateRequest transactionUpdateRequest) {
        return new ResponseEntity<>(transactionApi.updateTransaction(id, transactionUpdateRequest), HttpStatus.OK);
    }

}
