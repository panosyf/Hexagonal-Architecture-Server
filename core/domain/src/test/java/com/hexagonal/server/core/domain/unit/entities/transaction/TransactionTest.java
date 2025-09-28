package com.hexagonal.server.core.domain.unit.entities.transaction;

import com.hexagonal.server.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.shared.kernel.common.valueobjects.Timestamp;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static com.hexagonal.server.core.domain.common.mocks.transaction.TransactionMocks.generateTransaction;
import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {

    @Test
    void updateStatusTest() {
        // given
        Transaction transaction = generateTransaction();
        TransactionStatusEnum newStatus = TransactionStatusEnum.COMPLETED;
        Timestamp timestampBeforeUpdate = Timestamp.valueOf(Instant.now().minus(10, ChronoUnit.NANOS));
        Timestamp oldUpdatedAt = transaction.getUpdatedAt().minusNanos(100);
        TransactionStatusEnum oldStatus = transaction.getStatus();
        // when
        transaction.updateStatus(newStatus);
        // then
        assertThat(transaction.getStatus().equals(newStatus)).isTrue();
        assertThat(transaction.getStatus().equals(oldStatus)).isFalse();
        assertThat(transaction.getUpdatedAt().equals(oldUpdatedAt)).isFalse();
        assertThat(transaction.getUpdatedAt().isAfter(timestampBeforeUpdate)).isTrue();
    }

}
