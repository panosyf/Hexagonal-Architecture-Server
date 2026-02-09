package com.hexagonal.server.account.application.unit.apis.transaction;

import com.hexagonal.server.account.application.apis.account.AccountApi;
import com.hexagonal.server.account.application.apis.transaction.TransactionApi;
import com.hexagonal.server.account.application.apis.transaction.TransactionApiImpl;
import com.hexagonal.server.account.application.common.constants.transaction.Ids;
import com.hexagonal.server.account.application.common.mocks.transaction.TransactionCreateRequestMocks;
import com.hexagonal.server.account.application.common.mocks.transaction.TransactionMocks;
import com.hexagonal.server.account.application.common.mocks.transaction.TransactionUpdateRequestMocks;
import com.hexagonal.server.account.application.converters.transaction.in.TransactionCreateRequestToCommand;
import com.hexagonal.server.account.application.converters.transaction.out.TransactionToDto;
import com.hexagonal.server.account.application.model.requests.transaction.TransactionCreateRequest;
import com.hexagonal.server.account.application.model.requests.transaction.TransactionUpdateRequest;
import com.hexagonal.server.account.application.model.responses.transaction.TransactionCreationResponse;
import com.hexagonal.server.account.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.account.core.domain.exceptions.illegalargument.transaction.InsufficientBalanceException;
import com.hexagonal.server.account.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.account.core.domain.service.logic.transaction.TransactionDomainService;
import com.hexagonal.server.account.core.domain.service.model.commands.transaction.CreateTransactionCommand;
import com.hexagonal.server.account.core.domain.service.model.commands.transaction.UpdateTransactionCommand;
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
