package com.hexagonal.architecture.server.api.model.requests;

public record AccountCreateRequest(
        String email,
        String username,
        String password,
        String firstname,
        String lastname) {
}
