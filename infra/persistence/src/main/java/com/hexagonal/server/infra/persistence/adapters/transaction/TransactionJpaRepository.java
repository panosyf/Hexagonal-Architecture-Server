package com.hexagonal.server.infra.persistence.adapters.transaction;

import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.infra.persistence.daos.transaction.TransactionDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;

public interface TransactionJpaRepository extends JpaRepository<TransactionDao, String> {

    @Modifying
    @Query(
            value = "UPDATE transaction " +
                    "SET status = :status, " +
                    "updated_at = :updatedAt " +
                    "WHERE id = :id",
            nativeQuery = true)
    void updateStatus(
            @Param("id") String id,
            @Param("status") TransactionStatusEnum status,
            @Param("updatedAt") Instant updatedAt);

}
