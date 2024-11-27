package com.hexagonal.server.transaction.infra.persistence.converters;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.transaction.core.domain.entities.Transaction;
import com.hexagonal.server.transaction.infra.persistence.daos.TransactionDao;
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
