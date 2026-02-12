package com.hexagonal.server.shared.kernel.contract.model.request.account;

public record AccountCreateRequest(
        String email,
        String username,
        String password,
        String firstname,
        String lastname) {
}
