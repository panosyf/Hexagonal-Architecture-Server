package com.hexagonal.architecture.server.core.domain.service.unit.services.transaction;


import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.exceptions.elementnotfound.TransactionNotFoundException;
import com.hexagonal.architecture.server.core.domain.exceptions.utils.messages.ErrorMessageConstants;
import com.hexagonal.architecture.server.core.domain.model.constants.Amount;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;
import com.hexagonal.architecture.server.core.domain.service.common.constants.Ids;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionService;
import com.hexagonal.architecture.server.core.domain.service.services.transaction.TransactionServiceImpl;
import com.hexagonal.architecture.server.core.domain.valueobjects.Description;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static com.hexagonal.architecture.server.core.domain.exceptions.utils.ErrorUtils.generateErrorMessage;
import static com.hexagonal.architecture.server.core.domain.service.common.mocks.TransactionMocks.generatePendingTransaction;
import static com.hexagonal.architecture.server.core.domain.service.common.mocks.TransactionMocks.generateTransaction;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    private final TransactionRepositoryPort transactionRepositoryPort = mock(TransactionRepositoryPort.class);
    private TransactionService transactionService;

    private final ArgumentCaptor<Transaction> transactionCaptor = ArgumentCaptor.forClass(Transaction.class);


    @BeforeEach
    void init() {
        transactionService = new TransactionServiceImpl(transactionRepositoryPort);
    }

    @Test
    void getTransactionTest() {
        // given
        Timestamp now = Timestamp.now().minusNanos(100);
        Transaction transaction = generateTransaction();
        given(transactionRepositoryPort.findById(any(Id.class)))
                .willReturn(transaction);
        // when
        Transaction transactionResult = transactionService.getTransaction(Ids.TRANSACTION_ID_1);
        // then
        verify(transactionRepositoryPort, times(1))
                .findById(any(Id.class));
        assertAll(
                () -> assertEquals(TransactionType.TRANSFER, transactionResult.getType()),
                () -> assertEquals(Amount.AMOUNT_5, transactionResult.getAmount()),
                () -> assertEquals(Description.emptyDescription(), transactionResult.getDescription()),
                () -> assertEquals(Ids.ACCOUNT_ID_1, transactionResult.getDebtorAccountId()),
                () -> assertEquals(Ids.ACCOUNT_ID_2, transactionResult.getBeneficiaryAccountId()),
                () -> assertEquals(TransactionStatusEnum.CREATED, transactionResult.getStatus()),
                () -> assertThat(now.isBefore(transactionResult.getCreatedAt())).isTrue(),
                () -> assertNull(transactionResult.getUpdatedAt())
        );
    }

    @Test
    void getTransactionThrowsTransactionNotFoundExceptionTest() {
        // given
        given(transactionRepositoryPort.findById(any(Id.class)))
                .willThrow(new TransactionNotFoundException(Ids.TRANSACTION_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> transactionService.getTransaction(Ids.TRANSACTION_ID_1))
                .isInstanceOf(TransactionNotFoundException.class)
                .hasMessage(generateErrorMessage(ErrorMessageConstants.TRANSACTION_NOT_FOUND_EXCEPTION, Ids.TRANSACTION_ID_1.getValue()));
    }

    @Test
    void createTransactionTest() {
        // given
        Transaction transaction = generateTransaction();
        given(transactionRepositoryPort.save(any(Transaction.class)))
                .willReturn(transaction);
        // when
        transactionService.createTransaction(transaction);
        // then
        verify(transactionRepositoryPort, times(1))
                .save(transactionCaptor.capture());
        Transaction createdTransaction = transactionCaptor.getValue();
        assertAll(
                () -> assertEquals(TransactionType.TRANSFER, createdTransaction.getType()),
                () -> assertEquals(Amount.AMOUNT_5, createdTransaction.getAmount()),
                () -> assertEquals(Description.emptyDescription(), createdTransaction.getDescription()),
                () -> assertEquals(Ids.ACCOUNT_ID_1, createdTransaction.getDebtorAccountId()),
                () -> assertEquals(Ids.ACCOUNT_ID_2, createdTransaction.getBeneficiaryAccountId())
        );

    }

    @Test
    void updateTransactionTest() {
        // given
        Transaction transaction = generatePendingTransaction(Ids.TRANSACTION_ID_1);
        given(transactionRepositoryPort.findById(any(Id.class)))
                .willReturn(transaction);
        // when
        transactionService.updateTransaction(Ids.TRANSACTION_ID_1, TransactionStatusEnum.COMPLETED);
        // then
        verify(transactionRepositoryPort, times(1))
                .updateStatus(transactionCaptor.capture());
        assertThat(transactionCaptor.getValue().getStatus()).isEqualTo(TransactionStatusEnum.COMPLETED);
    }

    @Test
    void updateTransactionThrowsTransactionNotFoundExceptionTest() {
        // given
        given(transactionRepositoryPort.findById(any(Id.class)))
                .willThrow(new TransactionNotFoundException(Ids.TRANSACTION_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> transactionService.updateTransaction(Ids.TRANSACTION_ID_1, TransactionStatusEnum.COMPLETED))
                .isInstanceOf(TransactionNotFoundException.class)
                .hasMessage(generateErrorMessage(ErrorMessageConstants.TRANSACTION_NOT_FOUND_EXCEPTION, Ids.TRANSACTION_ID_1.getValue()));
    }

}
