package com.hexagonal.architecture.server.infra.persistence.converters.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.valueobjects.Id;
import com.hexagonal.architecture.server.infra.persistence.daos.TransactionDao;
import org.springframework.core.convert.converter.Converter;

public class TransactionToDomain implements Converter<TransactionDao, Transaction> {

    @Override
    public Transaction convert(TransactionDao transactionDao) {
        return new Transaction(
                Id.valueOf(transactionDao.getId()),
                transactionDao.getType(),
                transactionDao.getAmount(),
                transactionDao.getDescription(),
                Id.valueOf(transactionDao.getDebtorAccountId()),
                Id.valueOf(transactionDao.getBeneficiaryAccountId()),
                transactionDao.getStatus(),
                transactionDao.getCreatedAt(),
                transactionDao.getUpdatedAt());
    }

}
