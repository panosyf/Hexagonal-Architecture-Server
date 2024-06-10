package com.hexagonal.architecture.server.core.domain.unit.domains;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static com.hexagonal.architecture.server.core.domain.common.mocks.TransactionMocks.generateTransaction;
import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {

    @Test
    void updateStatusTest() {
        // given
        Transaction transaction = generateTransaction();
        TransactionStatusEnum newStatus = TransactionStatusEnum.PENDING;
        Instant timestampBeforeUpdate = Instant.now().minus(10, ChronoUnit.NANOS);
        Instant oldUpdatedAt = transaction.getUpdatedAt();
        TransactionStatusEnum oldStatus = transaction.getStatus();
        // when
        transaction.updateStatus(newStatus);
        // then
        assertThat(transaction.getStatus()).isEqualTo(newStatus);
        assertThat(transaction.getStatus()).isNotEqualTo(oldStatus);
        assertThat(transaction.getUpdatedAt()).isNotEqualTo(oldUpdatedAt);
        assertThat(transaction.getUpdatedAt()).isAfter(timestampBeforeUpdate);
    }

}
