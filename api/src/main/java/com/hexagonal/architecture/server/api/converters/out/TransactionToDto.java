package com.hexagonal.architecture.server.api.converters.out;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.api.model.dtos.TransactionDto;
import org.springframework.core.convert.converter.Converter;

public class TransactionToDto implements Converter<Transaction, TransactionDto> {

    @Override
    public TransactionDto convert(Transaction transaction) {
        return new TransactionDto(
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
