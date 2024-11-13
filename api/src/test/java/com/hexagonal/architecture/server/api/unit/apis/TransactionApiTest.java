package com.hexagonal.architecture.server.api.unit.apis;

import com.hexagonal.architecture.server.api.apis.account.AccountApi;
import com.hexagonal.architecture.server.api.common.constants.Ids;
import com.hexagonal.architecture.server.api.common.mocks.TransactionCreateRequestMocks;
import com.hexagonal.architecture.server.api.common.mocks.TransactionMocks;
import com.hexagonal.architecture.server.api.common.mocks.TransactionUpdateRequestMocks;
import com.hexagonal.architecture.server.api.converters.out.TransactionToDto;
import com.hexagonal.architecture.server.api.apis.transaction.TransactionApi;
import com.hexagonal.architecture.server.api.apis.transaction.TransactionApiImpl;
import com.hexagonal.architecture.server.api.model.responses.TransactionCreationResponse;
import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.exceptions.illegalargument.InsufficientBalanceException;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.api.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.api.model.requests.TransactionUpdateRequest;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.core.convert.support.GenericConversionService;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class TransactionApiTest {

    private final TransactionService transactionService = mock(TransactionService.class);
    private final AccountApi accountApi = mock(AccountApi.class);
    private final GenericConversionService genericConversionService = new GenericConversionService();
    private TransactionApi transactionApi;
    private final ArgumentCaptor<TransactionUpdateRequest> transactionUpdateRequestCaptor = ArgumentCaptor.forClass(TransactionUpdateRequest.class);

    @BeforeEach
    void init() {
        genericConversionService.addConverter(new TransactionToDto());
        transactionApi = new TransactionApiImpl(transactionService, accountApi, genericConversionService);
    }

    @Test
    void createTransactionTest() {
        // given
        TransactionCreateRequest transactionCreateRequest = TransactionCreateRequestMocks.generateTransactionCreateRequest();
        Transaction transaction = TransactionMocks.generateTransaction();
        given(transactionService.createTransaction(any(TransactionCreateRequest.class)))
                .willReturn(transaction);
        // when
        TransactionCreationResponse transactionCreationResponse = transactionApi.createTransaction(transactionCreateRequest);
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
                .when(accountApi)
                .decreaseBalance(anyString(), any(BigDecimal.class));
        // when
        TransactionCreationResponse transactionCreationResponse = transactionApi.createTransaction(transactionCreateRequest);
        // Then
        assertThat(transactionCreationResponse.status()).isEqualTo(TransactionStatusEnum.FAILED);
    }

    @Test
    void updateTransactionTest() {
        // given
        TransactionUpdateRequest transactionUpdateRequest = TransactionUpdateRequestMocks.generateTransactionUpdateRequest();
        Transaction transaction = TransactionMocks.generateTransaction();
        given(transactionService.updateTransaction(anyString(), , any(TransactionUpdateRequest.class)))
                .willReturn(transaction);
        // when
        transactionApi.updateTransaction(Ids.TRANSACTION_ID_1, transactionUpdateRequest);
        // Then
        verify(transactionService, times(1))
                .updateTransaction(anyString(), , transactionUpdateRequestCaptor.capture());
        assertThat(transactionUpdateRequestCaptor.getValue().transactionStatusEnum()).isEqualTo(TransactionStatusEnum.COMPLETED);
    }

}
