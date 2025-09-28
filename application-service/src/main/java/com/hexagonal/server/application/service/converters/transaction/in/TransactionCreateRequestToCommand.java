package com.hexagonal.server.application.service.converters.transaction.in;

import com.hexagonal.server.application.service.model.requests.TransactionCreateRequest;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionStatusEnum;
import com.hexagonal.server.core.domain.model.enums.transaction.TransactionType;
import com.hexagonal.server.core.domain.service.model.commands.transaction.CreateTransactionCommand;
import com.hexagonal.server.shared.kernel.common.valueobjects.Description;
import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Money;
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
