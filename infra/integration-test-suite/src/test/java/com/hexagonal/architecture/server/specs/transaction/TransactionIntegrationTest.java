package com.hexagonal.architecture.server.specs.transaction;

import com.hexagonal.architecture.server.common.constants.Endpoints;
import com.hexagonal.architecture.server.common.mocks.AccountMocks;
import com.hexagonal.architecture.server.common.mocks.TransactionCreateRequestMocks;
import com.hexagonal.architecture.server.core.domain.domains.account.Account;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.constants.Balance;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;
import com.hexagonal.architecture.server.config.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static com.hexagonal.architecture.server.common.mocks.TransactionUpdateRequestMocks.generateTransactionUpdateRequest;
import static com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum.COMPLETED;
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
        TransactionCreationResponse transactionCreationResponse = restTestClient.execute(HttpMethod.POST, Endpoints.CREATE_TRANSACTION, transactionCreateRequest)
                .expectStatus().isCreated()
                .expectBody(TransactionCreationResponse.class)
                .returnResult()
                .getResponseBody();
        //then
        assertThat(transactionCreationResponse.status()).isEqualTo(TransactionStatusEnum.PENDING);
        accountRepositoryPort.findById(accountDebtor.getId())
                .ifPresent(account -> assertThat(account.getBalance().equals(Balance.BALANCE_15)).isTrue());
        // when
        TransactionUpdateRequest transactionUpdateRequest = generateTransactionUpdateRequest(COMPLETED);
        restTestClient.execute(
                        HttpMethod.PUT,
                        Endpoints.UPDATE_TRANSACTION.replace("{id}", transactionCreationResponse.transactionId()),
                        transactionUpdateRequest)
                .expectStatus().isOk()
                .expectBody(TransactionUpdateResponse.class)
                .returnResult()
                .equals(new TransactionUpdateResponse(TransactionStatusEnum.COMPLETED));
        // TODO INCLUDE METHOD TO INCREASE THE BALANCE AFTER COMPLETION
//        accountRepositoryPort.findById(accountBeneficiary.getId())
//                .ifPresent(account -> assertThat(account.getBalance()).isEqualTo(Balance.BALANCE_10));
    }

}
