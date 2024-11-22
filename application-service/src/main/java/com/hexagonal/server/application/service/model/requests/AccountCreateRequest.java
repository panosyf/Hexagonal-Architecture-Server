package com.hexagonal.server.application.service.model.requests;

public record AccountCreateRequest(
        String email,
        String username,
        String password,
        String firstname,
        String lastname) {
}
