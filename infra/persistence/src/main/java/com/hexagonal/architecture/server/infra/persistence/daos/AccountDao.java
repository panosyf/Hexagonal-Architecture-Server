package com.hexagonal.architecture.server.infra.persistence.daos;

import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.core.domain.valueobjects.Money;
import com.hexagonal.architecture.server.core.domain.valueobjects.Name;
import com.hexagonal.architecture.server.core.domain.valueobjects.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity(name = "account")
@Table(name = "account")
public class AccountDao extends DaoEntity {

    @jakarta.persistence.Id
    @Column(name = "id")
    private Id id;
    @Column(name = "name")
    private Name name;
    @Column(name = "balance")
    private Money balance;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    protected AccountDao() {
    }

    public AccountDao(Id id, Name name, Money balance, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
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
        AccountDao that = (AccountDao) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(balance, that.balance) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "AccountDao{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
