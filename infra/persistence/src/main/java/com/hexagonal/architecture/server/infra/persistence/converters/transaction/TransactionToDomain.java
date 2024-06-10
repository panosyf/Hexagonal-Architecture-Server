package com.hexagonal.architecture.server.infra.persistence.converters.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.infra.persistence.entities.TransactionEntity;
import org.springframework.core.convert.converter.Converter;

public class TransactionToDomain implements Converter<TransactionEntity, Transaction> {

    @Override
    public Transaction convert(TransactionEntity transactionEntity) {
        return new Transaction(
                transactionEntity.getId(),
                transactionEntity.getType(),
                transactionEntity.getAmount(),
                transactionEntity.getDescription(),
                transactionEntity.getDebtorAccountId(),
                transactionEntity.getBeneficiaryAccountId(),
                transactionEntity.getStatus(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdatedAt());
    }

}
