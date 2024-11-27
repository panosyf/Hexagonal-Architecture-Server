package com.hexagonal.server.transaction.application.service.apis;

import com.hexagonal.server.transaction.application.service.apis.exposed.TransactionApi;
import com.hexagonal.server.transaction.application.service.apis.exposed.TransactionApiImpl;
import com.hexagonal.server.transaction.application.service.apis.external.AccountApi;
import com.hexagonal.server.transaction.application.service.converters.in.TransactionCreateRequestToCommand;
import com.hexagonal.server.transaction.application.service.converters.out.TransactionToDto;
import com.hexagonal.server.transaction.application.service.model.requests.TransactionCreateRequest;
import com.hexagonal.server.transaction.application.service.model.requests.TransactionUpdateRequest;
import com.hexagonal.server.transaction.application.service.model.responses.TransactionCreationResponse;
import com.hexagonal.server.transaction.core.domain.entities.Transaction;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.transaction.core.domain.exceptions.illegalargument.InsufficientBalanceException;
import com.hexagonal.server.transaction.core.domain.service.logic.TransactionDomainService;
import com.hexagonal.server.transaction.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.transaction.core.domain.service.model.commands.UpdateTransactionCommand;
import com.hexagonal.server.transaction.application.service.common.constants.Ids;
import com.hexagonal.server.transaction.application.service.common.mocks.TransactionCreateRequestMocks;
import com.hexagonal.server.transaction.application.service.common.mocks.TransactionMocks;
import com.hexagonal.server.transaction.application.service.common.mocks.TransactionUpdateRequestMocks;
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

    private final TransactionDomainService transactionDomainService = mock(TransactionDomainService.class);
    private final AccountApi accountApi = mock(AccountApi.class);
    private final GenericConversionService genericConversionService = new GenericConversionService();
    private TransactionApi transactionApi;
    private final ArgumentCaptor<UpdateTransactionCommand> updateTransactionCommandCaptor = ArgumentCaptor.forClass(UpdateTransactionCommand.class);

    @BeforeEach
    void init() {
        genericConversionService.addConverter(new TransactionToDto());
        genericConversionService.addConverter(new TransactionCreateRequestToCommand());
        transactionApi = new TransactionApiImpl(transactionDomainService, accountApi, genericConversionService);
    }

    @Test
    void createTransactionTest() {
        // given
        TransactionCreateRequest transactionCreateRequest = TransactionCreateRequestMocks.generateTransactionCreateRequest();
        Transaction transaction = TransactionMocks.generateTransaction();
        given(transactionDomainService.createTransaction(any(CreateTransactionCommand.class)))
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
        given(transactionDomainService.createTransaction(any(CreateTransactionCommand.class)))
                .willReturn(transaction);
        doThrow(new InsufficientBalanceException(transaction.getDebtorAccountId().getValue()))
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
        given(transactionDomainService.updateTransaction(any(UpdateTransactionCommand.class)))
                .willReturn(transaction);
        // when
        transactionApi.updateTransaction(Ids.TRANSACTION_ID_1.getValue(), transactionUpdateRequest);
        // Then
        verify(transactionDomainService, times(1))
                .updateTransaction(updateTransactionCommandCaptor.capture());
        assertThat(updateTransactionCommandCaptor.getValue().transactionStatusEnum()).isEqualTo(TransactionStatusEnum.COMPLETED);
    }

}
