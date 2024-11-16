package com.hexagonal.architecture.server.infra.persistence.daos;

import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity(name = "transaction")
@Table(name = "transaction")
public class TransactionDao extends DaoEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "description")
    private String description;
    @Column(name = "debtor_account_id")
    private String debtorAccountId;
    @Column(name = "beneficiary_account_id")
    private String beneficiaryAccountId;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    protected TransactionDao() {
    }

    public TransactionDao(
            String id,
            TransactionType type,
            BigDecimal amount,
            String description,
            String debtorAccountId,
            String beneficiaryAccountId,
            TransactionStatusEnum status,
            Instant createdAt,
            Instant updatedAt) {
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

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDebtorAccountId() {
        return debtorAccountId;
    }

    public void setDebtorAccountId(String debtorAccountId) {
        this.debtorAccountId = debtorAccountId;
    }

    public String getBeneficiaryAccountId() {
        return beneficiaryAccountId;
    }

    public void setBeneficiaryAccountId(String beneficiaryAccountId) {
        this.beneficiaryAccountId = beneficiaryAccountId;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDao that = (TransactionDao) o;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(amount, that.amount) && Objects.equals(description, that.description) && Objects.equals(debtorAccountId, that.debtorAccountId) && Objects.equals(beneficiaryAccountId, that.beneficiaryAccountId) && status == that.status && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, description, debtorAccountId, beneficiaryAccountId, status, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "TransactionDao{" +
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
