package com.hexagonal.server.infra.specs.account;

import com.hexagonal.server.infra.common.constants.account.Endpoints;
import com.hexagonal.server.account.core.domain.model.enums.account.AccountCreationStatusEnum;
import com.hexagonal.server.account.application.service.model.requests.account.AccountCreateRequest;
import com.hexagonal.server.account.application.service.model.responses.account.AccountCreationResponse;
import com.hexagonal.server.infra.config.AppIntegrationTest;
import org.junit.jupiter.api.Test;

import static com.hexagonal.server.infra.common.mocks.account.AccountCreateRequestMocks.generateAccountCreateRequest;
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
