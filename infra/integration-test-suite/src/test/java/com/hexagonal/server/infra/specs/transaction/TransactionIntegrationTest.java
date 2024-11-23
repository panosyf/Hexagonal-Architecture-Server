package com.hexagonal.server.infra.specs.transaction;

import com.hexagonal.server.application.service.model.responses.TransactionCreationResponse;
import com.hexagonal.server.application.service.model.responses.TransactionUpdateResponse;
import com.hexagonal.server.core.domain.domains.account.Account;
import com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.server.application.service.model.requests.TransactionCreateRequest;
import com.hexagonal.server.application.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.infra.common.constants.Endpoints;
import com.hexagonal.server.infra.common.mocks.AccountMocks;
import com.hexagonal.server.infra.common.mocks.TransactionCreateRequestMocks;
import com.hexagonal.server.infra.config.AbstractIntegrationTest;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.hexagonal.server.core.domain.model.enums.TransactionStatusEnum.COMPLETED;
import static com.hexagonal.server.infra.common.mocks.TransactionUpdateRequestMocks.generateTransactionUpdateRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionIntegrationTest extends AbstractIntegrationTest {

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
        TransactionCreationResponse transactionCreationResponse = crudTestClient.post(Endpoints.CREATE_TRANSACTION, transactionCreateRequest)
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
        crudTestClient.put(
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
