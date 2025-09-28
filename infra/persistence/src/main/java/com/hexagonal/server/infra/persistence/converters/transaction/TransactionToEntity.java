package com.hexagonal.server.infra.persistence.converters.transaction;

import com.hexagonal.server.core.domain.entities.transaction.Transaction;
import com.hexagonal.server.infra.persistence.daos.transaction.TransactionDao;
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
