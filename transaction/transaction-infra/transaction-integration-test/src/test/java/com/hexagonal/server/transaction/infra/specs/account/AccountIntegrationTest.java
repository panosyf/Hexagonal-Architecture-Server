package com.hexagonal.server.transaction.infra.specs.account;

import com.hexagonal.server.transaction.application.service.model.requests.AccountCreateRequest;
import com.hexagonal.server.transaction.application.service.model.responses.AccountCreationResponse;
import com.hexagonal.server.transaction.core.domain.enums.AccountCreationStatusEnum;
import com.hexagonal.server.transaction.infra.common.constants.Endpoints;
import com.hexagonal.server.transaction.infra.config.AppIntegrationTest;
import org.junit.jupiter.api.Test;

import static com.hexagonal.server.transaction.infra.common.mocks.AccountCreateRequestMocks.generateAccountCreateRequest;
import static org.assertj.core.api.Assertions.assertThat;

class AccountIntegrationTest extends AppIntegrationTest {

    @Test
    void userCreatesAccount() {
        //given
        AccountCreateRequest accountCreateRequest = generateAccountCreateRequest();
        //when
        AccountCreationResponse accountCreationResponse = requestTestClient.post(Endpoints.CREATE_ACCOUNT, accountCreateRequest)
                .expectStatus().isCreated()
                .expectBody(AccountCreationResponse.class)
                .returnResult()
                .getResponseBody();
        //then
        assertThat(accountRepositoryPort.findTotalEntries()).isEqualTo(1);
        assertThat(accountCreationResponse).isNotNull();
        assertThat(accountCreationResponse.status()).isEqualTo(AccountCreationStatusEnum.SUCCESSFUL);
    }

}
