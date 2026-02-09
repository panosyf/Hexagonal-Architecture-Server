package com.hexagonal.server.infra.rest.controllers.account;

import com.hexagonal.server.account.application.apis.account.AccountApi;
import com.hexagonal.server.account.application.model.responses.account.AccountCreationResponse;
import com.hexagonal.server.account.application.model.responses.account.AccountResponse;
import com.hexagonal.server.account.application.model.requests.account.AccountCreateRequest;
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
