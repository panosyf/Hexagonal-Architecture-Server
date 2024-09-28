package com.hexagonal.architecture.server.api.unit.facades;

import com.hexagonal.architecture.server.api.converters.out.TransactionToDto;
import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.exceptions.baddata.InsufficientBalanceException;
import com.hexagonal.architecture.server.api.facades.transaction.TransactionFacade;
import com.hexagonal.architecture.server.api.facades.transaction.TransactionFacadeImpl;
import com.hexagonal.architecture.server.api.common.constants.Ids;
import com.hexagonal.architecture.server.api.common.mocks.TransactionCreateRequestMocks;
import com.hexagonal.architecture.server.api.common.mocks.TransactionMocks;
import com.hexagonal.architecture.server.api.common.mocks.TransactionUpdateRequestMocks;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.api.model.responses.TransactionUpdateResponse;

import com.hexagonal.architecture.server.core.domain.service.services.account.AccountService;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.GenericConversionService;

import java.math.BigDecimal;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class TransactionFacadeTest {

    private final TransactionService transactionService = mock(TransactionService.class);
    private final AccountService accountService = mock(AccountService.class);
    private final GenericConversionService genericConversionService = new GenericConversionService();
    private TransactionFacade transactionFacade;

    @BeforeEach
    void init() {
        genericConversionService.addConverter(new TransactionToDto());
        transactionFacade = new TransactionFacadeImpl(transactionService, accountService, genericConversionService);
    }

    @Test
    void createTransactionTest() {
        // given
        TransactionCreateRequest transactionCreateRequest = TransactionCreateRequestMocks.generateTransactionCreateRequest();
        Transaction transaction = TransactionMocks.generateTransaction();
        given(transactionService.createTransaction(any(TransactionCreateRequest.class)))
                .willReturn(transaction);
        // when
        TransactionCreationResponse transactionCreationResponse = transactionFacade.createTransaction(transactionCreateRequest);
        // Then
        assertThat(transactionCreationResponse.status()).isEqualTo(TransactionStatusEnum.PENDING);
    }

    @Test
    void createTransactionFailedTest() {
        // given
        TransactionCreateRequest transactionCreateRequest = TransactionCreateRequestMocks.generateTransactionCreateRequest();
        Transaction transaction = TransactionMocks.generateTransaction();
        given(transactionService.createTransaction(any(TransactionCreateRequest.class)))
                .willReturn(transaction);
        doThrow(new InsufficientBalanceException(transaction.getDebtorAccountId()))
                .when(accountService)
                .decreaseBalance(anyString(), any(BigDecimal.class));
        // when
        TransactionCreationResponse transactionCreationResponse = transactionFacade.createTransaction(transactionCreateRequest);
        // Then
        assertThat(transactionCreationResponse.status()).isEqualTo(TransactionStatusEnum.FAILED);
    }

    @Test
    void updateTransactionTest() {
        // given
        TransactionUpdateRequest transactionCreateRequest = TransactionUpdateRequestMocks.generateTransactionUpdateRequest();
        // when
        TransactionUpdateResponse transactionCreateResponse = transactionFacade.updateTransaction(Ids.TRANSACTION_ID_1, transactionCreateRequest);
        // Then
        assertThat(transactionCreateResponse.status()).isEqualTo(TransactionStatusEnum.COMPLETED);
    }

}
