package com.hexagonal.server.account.application.service.model.requests.account;

public record AccountCreateRequest(
        String email,
        String username,
        String password,
        String firstname,
        String lastname) {
}
