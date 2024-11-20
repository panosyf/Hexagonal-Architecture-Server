package com.hexagonal.architecture.server.infra.persistence.daos;

import com.hexagonal.architecture.server.infra.persistence.converters.valueobjects.*;
import com.hexagonal.architecture.server.shared.kernel.valueobjects.*;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "account")
@Table(name = "account")
public class AccountDao extends DaoEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    @Convert(converter = EmailAttributeConverter.class)
    private Email email;

    @Column(name = "username")
    @Convert(converter = UsernameAttributeConverter.class)
    private Username username;

    @Column(name = "password")
    @Convert(converter = PasswordAttributeConverter.class)
    private Password password;

    @Column(name = "name")
    @Convert(converter = NameAttributeConverter.class)
    private Name name;

    @Column(name = "balance")
    @Convert(converter = MoneyAttributeConverter.class)
    private Money balance;

    @Column(name = "created_at")
    @Convert(converter = TimestampAttributeConverter.class)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @Convert(converter = TimestampAttributeConverter.class)
    private Timestamp updatedAt;

    protected AccountDao() {
    }

    public AccountDao(
            final String id,
            final Email email,
            final Username username,
            final Password password,
            final Name name,
            final Money balance,
            final Timestamp createdAt,
            final Timestamp updatedAt) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
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
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(name, that.name) && Objects.equals(balance, that.balance) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, name, balance, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "AccountDao{" +
                "id=" + id +
                ", email=" + email +
                ", username=" + username +
                ", password=" + "[REDACTED]" +
                ", name=" + name +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
