package com.hexagonal.architecture.server.infra.persistence.daos;

import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;
import com.hexagonal.architecture.server.core.domain.valueobjects.Description;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;
import com.hexagonal.architecture.server.core.domain.valueobjects.Timestamp;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "transaction")
@Table(name = "transaction")
public class TransactionDao extends DaoEntity {

    @jakarta.persistence.Id
    @Column(name = "id")
    private Id id;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Column(name = "amount")
    private Money amount;
    @Column(name = "description")
    private Description description;
    @Column(name = "debtor_account_id")
    private Id debtorAccountId;
    @Column(name = "beneficiary_account_id")
    private Id beneficiaryAccountId;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    protected TransactionDao() {
    }

    public TransactionDao(
            Id id,
            TransactionType type,
            Money amount,
            Description description,
            Id debtorAccountId,
            Id beneficiaryAccountId,
            TransactionStatusEnum status,
            Timestamp createdAt,
            Timestamp updatedAt) {
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

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Id getDebtorAccountId() {
        return debtorAccountId;
    }

    public void setDebtorAccountId(Id debtorAccountId) {
        this.debtorAccountId = debtorAccountId;
    }

    public Id getBeneficiaryAccountId() {
        return beneficiaryAccountId;
    }

    public void setBeneficiaryAccountId(Id beneficiaryAccountId) {
        this.beneficiaryAccountId = beneficiaryAccountId;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
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
