package com.hexagonal.architecture.server.infra.rest.controllers;

import com.hexagonal.architecture.server.api.facades.account.AccountFacade;
import com.hexagonal.architecture.server.api.model.dtos.AccountDto;
import com.hexagonal.architecture.server.api.model.responses.AccountCreationResponse;
import com.hexagonal.architecture.server.core.domain.service.model.requests.AccountCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountFacade accountFacade;

    public AccountController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @PostMapping(path = "/api/v1/accounts")
    public ResponseEntity<AccountCreationResponse> createAccount(@RequestBody AccountCreateRequest accountCreateRequest) {
        return new ResponseEntity<>(accountFacade.createAccount(accountCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/api/v1/accounts/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable(name = "id") String id) {
        return new ResponseEntity<>(accountFacade.getAccount(id), HttpStatus.OK);
    }

}
