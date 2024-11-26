package com.hexagonal.server.transaction.core.domain.domains;

import com.hexagonal.server.shared.kernel.common.valueobjects.Timestamp;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static com.hexagonal.server.transaction.core.domain.common.mocks.TransactionMocks.generateTransaction;
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
