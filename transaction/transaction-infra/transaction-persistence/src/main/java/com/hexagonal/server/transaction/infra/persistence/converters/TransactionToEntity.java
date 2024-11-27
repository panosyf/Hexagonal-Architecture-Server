package com.hexagonal.server.transaction.infra.persistence.converters;

import com.hexagonal.server.transaction.core.domain.entities.Transaction;
import com.hexagonal.server.transaction.infra.persistence.daos.TransactionDao;
import org.springframework.core.convert.converter.Converter;

public class TransactionToEntity implements Converter<Transaction, TransactionDao> {

    @Override
    public TransactionDao convert(Transaction transaction) {
        return new TransactionDao(
                transaction.getId().getValue(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getDebtorAccountId().getValue(),
                transaction.getBeneficiaryAccountId().getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

}