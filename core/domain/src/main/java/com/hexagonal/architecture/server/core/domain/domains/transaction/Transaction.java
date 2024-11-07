package com.hexagonal.architecture.server.core.domain.domains.transaction;

import com.hexagonal.architecture.server.core.domain.domains.DomainEntity;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import static com.hexagonal.architecture.server.core.domain.utils.TimeUtils.now;

public class Transaction extends DomainEntity {

    private String id;
    private TransactionType type;
    private BigDecimal amount;
    private String description;
    private String debtorAccountId;
    private String beneficiaryAccountId;
    private TransactionStatusEnum status;
    private Instant createdAt;
    private Instant updatedAt;

    private Transaction() {
    }

    public Transaction(
            final TransactionType type,
            final BigDecimal amount,
            final String description,
            final String debtorAccountId,
            final String beneficiaryAccountId,
            final TransactionStatusEnum status) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.debtorAccountId = debtorAccountId;
        this.beneficiaryAccountId = beneficiaryAccountId;
        this.status = status;
        this.createdAt = now();
        this.updatedAt = null;
    }

    public Transaction(
            final String id,
            final TransactionType type,
            final BigDecimal amount,
            final String description,
            final String debtorAccountId,
            final String beneficiaryAccountId,
            final TransactionStatusEnum status) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.debtorAccountId = debtorAccountId;
        this.beneficiaryAccountId = beneficiaryAccountId;
        this.status = status;
        this.createdAt = now();
        this.updatedAt = null;
    }

    public Transaction(
            final String id,
            final TransactionType type,
            final BigDecimal amount,
            final String description,
            final String debtorAccountId,
            final String beneficiaryAccountId,
            final TransactionStatusEnum status,
            final Instant createdAt,
            final Instant updatedAt) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.debtorAccountId = debtorAccountId;
        this.beneficiaryAccountId = beneficiaryAccountId;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDebtorAccountId() {
        return debtorAccountId;
    }

    public String getBeneficiaryAccountId() {
        return beneficiaryAccountId;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void updateStatus(TransactionStatusEnum status) {
        this.status = status;
        this.updatedAt = now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(amount, that.amount) && Objects.equals(description, that.description) && Objects.equals(debtorAccountId, that.debtorAccountId) && Objects.equals(beneficiaryAccountId, that.beneficiaryAccountId) && status == that.status && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, description, debtorAccountId, beneficiaryAccountId, status, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", debtorAccountId='" + debtorAccountId + '\'' +
                ", beneficiaryAccountId='" + beneficiaryAccountId + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
