package com.hexagonal.server.core.domain.service.unit.services.transaction;


import com.hexagonal.server.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.core.domain.exceptions.elementnotfound.transaction.TransactionNotFoundException;
import com.hexagonal.server.core.domain.exceptions.utils.messages.transaction.ErrorMessageConstants;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionType;
import com.hexagonal.server.core.domain.service.common.constants.Ids;
import com.hexagonal.server.core.domain.service.logic.transaction.TransactionDomainService;
import com.hexagonal.server.core.domain.service.logic.transaction.TransactionDomainServiceImpl;
import com.hexagonal.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.GetTransactionCommand;
import com.hexagonal.server.core.domain.service.model.commands.UpdateTransactionCommand;
import com.hexagonal.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.server.shared.kernel.common.exception.utils.ErrorUtils;
import com.hexagonal.server.shared.kernel.common.valueobjects.Description;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.shared.kernel.common.valueobjects.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;

import static com.hexagonal.server.core.domain.service.common.mocks.CreateTransactionCommandMocks.generateCreateTransactionCommand;
import static com.hexagonal.server.core.domain.service.common.mocks.GetTransactionCommandMocks.generateGetTransactionCommand;
import static com.hexagonal.server.core.domain.service.common.mocks.TransactionMocks.generatePendingTransaction;
import static com.hexagonal.server.core.domain.service.common.mocks.TransactionMocks.generateTransaction;
import static com.hexagonal.server.core.domain.service.common.mocks.UpdateTransactionCommandMocks.generateUpdateTransactionCommand;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class TransactionDomainServiceTest {

    private final TransactionRepositoryPort transactionRepositoryPort = mock(TransactionRepositoryPort.class);
    private TransactionDomainService transactionDomainService;
    private final ArgumentCaptor<Transaction> transactionCaptor = ArgumentCaptor.forClass(Transaction.class);
    private static final Money AMOUNT_5 = Money.of(BigDecimal.valueOf(5));

    @BeforeEach
    void init() {
        transactionDomainService = new TransactionDomainServiceImpl(transactionRepositoryPort);
    }

    @Test
    void getTransactionTest() {
        // given
        Timestamp now = Timestamp.now().minusNanos(100);
        Transaction transaction = generateTransaction();
        GetTransactionCommand getTransactionCommand = generateGetTransactionCommand();
        given(transactionRepositoryPort.findById(any(Id.class)))
                .willReturn(transaction);
        // when
        Transaction transactionResult = transactionDomainService.getTransaction(getTransactionCommand);
        // then
        verify(transactionRepositoryPort, times(1))
                .findById(any(Id.class));
        assertAll(
                () -> assertEquals(TransactionType.TRANSFER, transactionResult.getType()),
                () -> assertEquals(AMOUNT_5, transactionResult.getAmount()),
                () -> assertEquals(Description.emptyDescription(), transactionResult.getDescription()),
                () -> assertEquals(Ids.ACCOUNT_ID_1, transactionResult.getDebtorAccountId()),
                () -> assertEquals(Ids.ACCOUNT_ID_2, transactionResult.getBeneficiaryAccountId()),
                () -> assertEquals(TransactionStatusEnum.PENDING, transactionResult.getStatus()),
                () -> assertThat(now.isBefore(transactionResult.getCreatedAt())).isTrue(),
                () -> assertThat(now.isBefore(transactionResult.getUpdatedAt())).isTrue(),
                () -> assertThat(transactionResult.getCreatedAt().equals(transactionResult.getUpdatedAt())).isTrue()
        );
    }

    @Test
    void getTransactionThrowsTransactionNotFoundExceptionTest() {
        // given
        GetTransactionCommand getTransactionCommand = generateGetTransactionCommand();
        given(transactionRepositoryPort.findById(any(Id.class)))
                .willThrow(new TransactionNotFoundException(Ids.TRANSACTION_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> transactionDomainService.getTransaction(getTransactionCommand))
                .isInstanceOf(TransactionNotFoundException.class)
                .hasMessage(ErrorUtils.generateErrorMessage(ErrorMessageConstants.TRANSACTION_NOT_FOUND_EXCEPTION, Ids.TRANSACTION_ID_1.getValue()));
    }

    @Test
    void createTransactionTest() {
        // given
        CreateTransactionCommand createTransactionCommand = generateCreateTransactionCommand();
        // when
        transactionDomainService.createTransaction(createTransactionCommand);
        // then
        verify(transactionRepositoryPort, times(1))
                .save(transactionCaptor.capture());
        Transaction createdTransaction = transactionCaptor.getValue();
        assertAll(
                () -> assertEquals(TransactionType.TRANSFER, createdTransaction.getType()),
                () -> assertEquals(AMOUNT_5, createdTransaction.getAmount()),
                () -> assertEquals(Description.emptyDescription(), createdTransaction.getDescription()),
                () -> assertEquals(Ids.ACCOUNT_ID_1, createdTransaction.getDebtorAccountId()),
                () -> assertEquals(Ids.ACCOUNT_ID_2, createdTransaction.getBeneficiaryAccountId())
        );

    }

    @Test
    void updateTransactionTest() {
        // given
        UpdateTransactionCommand updateTransactionCommand = generateUpdateTransactionCommand();
        Transaction transaction = generatePendingTransaction(Ids.TRANSACTION_ID_1);
        given(transactionRepositoryPort.findById(any(Id.class)))
                .willReturn(transaction);
        // when
        transactionDomainService.updateTransaction(updateTransactionCommand);
        // then
        verify(transactionRepositoryPort, times(1))
                .updateStatus(transactionCaptor.capture());
        assertThat(transactionCaptor.getValue().getStatus()).isEqualTo(TransactionStatusEnum.COMPLETED);
    }

    @Test
    void updateTransactionThrowsTransactionNotFoundExceptionTest() {
        // given
        UpdateTransactionCommand updateTransactionCommand = generateUpdateTransactionCommand();
        given(transactionRepositoryPort.findById(any(Id.class)))
                .willThrow(new TransactionNotFoundException(Ids.TRANSACTION_ID_1.getValue()));
        // then
        assertThatThrownBy(() -> transactionDomainService.updateTransaction(updateTransactionCommand))
                .isInstanceOf(TransactionNotFoundException.class)
                .hasMessage(ErrorUtils.generateErrorMessage(ErrorMessageConstants.TRANSACTION_NOT_FOUND_EXCEPTION, Ids.TRANSACTION_ID_1.getValue()));
    }

}
