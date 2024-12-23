package com.hexagonal.server.infra.common.constants;

public class Endpoints {

    private Endpoints() {
    }

    public static final String CREATE_ACCOUNT = "/api/v1/accounts";
    public static final String CREATE_TRANSACTION = "/api/v1/transactions";
    public static final String UPDATE_TRANSACTION = "/api/v1/transactions/{id}";

}
