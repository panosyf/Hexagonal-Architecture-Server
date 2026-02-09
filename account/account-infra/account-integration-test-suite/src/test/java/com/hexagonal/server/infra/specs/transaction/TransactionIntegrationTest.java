package com.hexagonal.server.infra.specs.transaction;

import com.hexagonal.server.account.application.service.model.requests.transaction.TransactionCreateRequest;
import com.hexagonal.server.account.application.service.model.requests.transaction.TransactionUpdateRequest;
import com.hexagonal.server.account.application.service.model.responses.transaction.TransactionCreationResponse;
import com.hexagonal.server.account.application.service.model.responses.transaction.TransactionUpdateResponse;
import com.hexagonal.server.account.core.domain.entities.account.Account;
import com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.infra.common.constants.transaction.Endpoints;
import com.hexagonal.server.infra.common.mocks.account.AccountMocks;
import com.hexagonal.server.infra.common.mocks.transaction.TransactionCreateRequestMocks;
import com.hexagonal.server.infra.config.AppIntegrationTest;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionStatusEnum.COMPLETED;
import static com.hexagonal.server.infra.common.mocks.transaction.TransactionUpdateRequestMocks.generateTransactionUpdateRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionIntegrationTest extends AppIntegrationTest {

    private static final Money BALANCE_5 = Money.of(BigDecimal.valueOf(5));
    private static final Money BALANCE_10 = Money.of(BigDecimal.TEN);
    private static final Money BALANCE_15 = Money.of(BigDecimal.valueOf(15));
    private static final Money BALANCE_20 = Money.of(BigDecimal.valueOf(20));

    @Test
    void userCreatesNewTransactionThenItsCompleted() {
        // given
        Account accountDebtor = AccountMocks.generateAccount(BALANCE_20);
        Account accountBeneficiary = AccountMocks.generateAccount(BALANCE_5);
        accountRepositoryPort.save(accountDebtor);
        accountRepositoryPort.save(accountBeneficiary);
        TransactionCreateRequest transactionCreateRequest = TransactionCreateRequestMocks
                .generateTransactionCreateRequest(
                        accountDebtor.getId().getValue(),
                        accountBeneficiary.getId().getValue());
        // when
        TransactionCreationResponse transactionCreationResponse = requestTestClient.post(Endpoints.CREATE_TRANSACTION, transactionCreateRequest)
                .expectStatus().isCreated()
                .expectBody(TransactionCreationResponse.class)
                .returnResult()
                .getResponseBody();
        //then
        assertThat(transactionCreationResponse.status()).isEqualTo(TransactionStatusEnum.PENDING);
        Account account = accountRepositoryPort.findById(accountDebtor.getId());
        assertThat(account.getBalance()).isEqualTo(BALANCE_15);
        // when
        TransactionUpdateRequest transactionUpdateRequest = generateTransactionUpdateRequest(COMPLETED);
        requestTestClient.put(
                        Endpoints.UPDATE_TRANSACTION.replace("{id}", transactionCreationResponse.id()),
                        transactionUpdateRequest)
                .expectStatus().isOk()
                .expectBody(TransactionUpdateResponse.class)
                .returnResult()
                .equals(new TransactionUpdateResponse(transactionCreationResponse.id(), TransactionStatusEnum.COMPLETED));
        Account beneficiaryaccount = accountRepositoryPort.findById(accountBeneficiary.getId());
        assertThat(beneficiaryaccount.getBalance()).isEqualTo(BALANCE_10);
    }

}
