package com.hexagonal.architecture.server.infra.rest.controllers;

import com.hexagonal.architecture.server.api.apis.account.AccountApi;
import com.hexagonal.architecture.server.api.model.responses.AccountCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.AccountResponse;
import com.hexagonal.architecture.server.api.model.requests.AccountCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountApi accountApi;

    public AccountController(AccountApi accountApi) {
        this.accountApi = accountApi;
    }

    @PostMapping(path = "/api/v1/accounts")
    public ResponseEntity<AccountCreationResponse> createAccount(@RequestBody AccountCreateRequest accountCreateRequest) {
        return new ResponseEntity<>(accountApi.createAccount(accountCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/api/v1/accounts/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(accountApi.getAccount(id), HttpStatus.OK);
    }

}
