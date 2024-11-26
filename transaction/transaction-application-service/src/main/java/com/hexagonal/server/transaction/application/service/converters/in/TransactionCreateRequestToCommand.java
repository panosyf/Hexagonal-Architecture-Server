package com.hexagonal.server.transaction.application.service.converters.in;

import com.hexagonal.server.shared.kernel.common.valueobjects.Description;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
import com.hexagonal.server.transaction.application.service.model.requests.TransactionCreateRequest;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.transaction.core.domain.enums.TransactionType;
import com.hexagonal.server.transaction.core.domain.service.commands.CreateTransactionCommand;
import org.springframework.core.convert.converter.Converter;

public class TransactionCreateRequestToCommand implements Converter<TransactionCreateRequest, CreateTransactionCommand> {

    @Override
    public CreateTransactionCommand convert(TransactionCreateRequest transactionCreateRequest) {
        TransactionType type = transactionCreateRequest.type();
        Money amount = Money.of(transactionCreateRequest.amount());
        Description description = Description.valueOf(transactionCreateRequest.description());
        Id debtorAccountId = Id.valueOf(transactionCreateRequest.debtorAccountId());
        Id beneficiaryAccountId = Id.valueOf(transactionCreateRequest.beneficiaryAccountId());
        return new CreateTransactionCommand(
                type,
                amount,
                description,
                debtorAccountId,
                beneficiaryAccountId,
                TransactionStatusEnum.PENDING);
    }

}
