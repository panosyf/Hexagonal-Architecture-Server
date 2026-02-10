package com.hexagonal.server.infra.persistence.converter.transaction;

import com.hexagonal.server.account.core.domain.transaction.Transaction;
import com.hexagonal.server.infra.persistence.entity.transaction.TransactionEntity;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import org.springframework.core.convert.converter.Converter;

public class TransactionToDomain implements Converter<TransactionEntity, Transaction> {

    @Override
    public Transaction convert(TransactionEntity transactionEntity) {
        return new Transaction(
                Id.valueOf(transactionEntity.getId()),
                transactionEntity.getType(),
                transactionEntity.getAmount(),
                transactionEntity.getDescription(),
                Id.valueOf(transactionEntity.getDebtorAccountId()),
                Id.valueOf(transactionEntity.getBeneficiaryAccountId()),
                transactionEntity.getStatus(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdatedAt());
    }

}
