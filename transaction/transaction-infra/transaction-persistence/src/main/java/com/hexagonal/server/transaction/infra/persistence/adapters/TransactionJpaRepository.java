package com.hexagonal.server.transaction.infra.persistence.adapters;

import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.transaction.infra.persistence.daos.TransactionDao;
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