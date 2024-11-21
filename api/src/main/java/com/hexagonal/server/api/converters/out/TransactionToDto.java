package com.hexagonal.server.api.converters.out;

import com.hexagonal.server.api.model.dtos.TransactionDto;
import com.hexagonal.server.core.domain.domains.transaction.Transaction;
import org.springframework.core.convert.converter.Converter;

public class TransactionToDto implements Converter<Transaction, TransactionDto> {

    @Override
    public TransactionDto convert(Transaction transaction) {
        return new TransactionDto(
                transaction.getId().getValue(),
                transaction.getType(),
                transaction.getAmount().getValue(),
                transaction.getDescription().getValue(),
                transaction.getDebtorAccountId().getValue(),
                transaction.getBeneficiaryAccountId().getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt().getTime(),
                transaction.getUpdatedAt().getTime()
        );
    }

}