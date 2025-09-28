package com.hexagonal.server.infra.rest.controllers;

import com.hexagonal.server.application.service.apis.transaction.TransactionApi;
import com.hexagonal.server.application.service.model.responses.transaction.TransactionResponse;
import com.hexagonal.server.application.service.model.requests.transaction.TransactionCreateRequest;
import com.hexagonal.server.application.service.model.requests.transaction.TransactionUpdateRequest;
import com.hexagonal.server.application.service.model.responses.transaction.TransactionCreationResponse;
import com.hexagonal.server.application.service.model.responses.transaction.TransactionUpdateResponse;
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
