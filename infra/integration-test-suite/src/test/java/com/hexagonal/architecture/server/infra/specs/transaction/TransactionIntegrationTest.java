package com.hexagonal.architecture.server.infra.specs.transaction;

import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;
import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.model.constants.Balance;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.infra.common.constants.Endpoints;
import com.hexagonal.architecture.server.infra.common.mocks.AccountMocks;
import com.hexagonal.architecture.server.infra.common.mocks.TransactionCreateRequestMocks;
import com.hexagonal.architecture.server.infra.config.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum.COMPLETED;
import static com.hexagonal.architecture.server.infra.common.mocks.TransactionUpdateRequestMocks.generateTransactionUpdateRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionIntegrationTest extends AbstractIntegrationTest {

    @Test
    void userCreatesNewTransactionThenItsCompleted() {
        // given
        Account accountDebtor = AccountMocks.generateAccount(Balance.BALANCE_20);
        Account accountBeneficiary = AccountMocks.generateAccount(Balance.BALANCE_5);
        accountRepositoryPort.save(accountDebtor);
        accountRepositoryPort.save(accountBeneficiary);
        TransactionCreateRequest transactionCreateRequest = TransactionCreateRequestMocks
                .generateTransactionCreateRequest(
                        accountDebtor.getId(),
                        accountBeneficiary.getId());
        // when
        TransactionCreationResponse transactionCreationResponse = crudTestClient.execute(HttpMethod.POST, Endpoints.CREATE_TRANSACTION, transactionCreateRequest)
                .expectStatus().isCreated()
                .expectBody(TransactionCreationResponse.class)
                .returnResult()
                .getResponseBody();
        //then
        assertThat(transactionCreationResponse.status()).isEqualTo(TransactionStatusEnum.PENDING);
        Account account = accountRepositoryPort.findById(accountDebtor.getId());
        assertThat(account.getBalance()).isEqualTo(Balance.BALANCE_15);
        // when
        TransactionUpdateRequest transactionUpdateRequest = generateTransactionUpdateRequest(COMPLETED);
        crudTestClient.execute(
                        HttpMethod.PUT,
                        Endpoints.UPDATE_TRANSACTION.replace("{id}", transactionCreationResponse.id()),
                        transactionUpdateRequest)
                .expectStatus().isOk()
                .expectBody(TransactionUpdateResponse.class)
                .returnResult()
                .equals(new TransactionUpdateResponse(transactionCreationResponse.id(), TransactionStatusEnum.COMPLETED));
        Account beneficiaryaccount = accountRepositoryPort.findById(accountBeneficiary.getId());
        assertThat(beneficiaryaccount.getBalance()).isEqualTo(Balance.BALANCE_10);
    }

}
