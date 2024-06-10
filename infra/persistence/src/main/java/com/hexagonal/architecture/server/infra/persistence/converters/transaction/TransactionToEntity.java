package com.hexagonal.architecture.server.infra.persistence.converters.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.infra.persistence.entities.TransactionEntity;
import org.springframework.core.convert.converter.Converter;

public class TransactionToEntity implements Converter<Transaction, TransactionEntity> {

    @Override
    public TransactionEntity convert(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getDebtorAccountId(),
                transaction.getBeneficiaryAccountId(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

}
