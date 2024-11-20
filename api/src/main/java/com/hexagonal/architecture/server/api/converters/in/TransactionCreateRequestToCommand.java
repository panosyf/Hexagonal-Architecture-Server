package com.hexagonal.architecture.server.api.converters.in;

import com.hexagonal.architecture.server.api.model.requests.TransactionCreateRequest;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionType;
import com.hexagonal.architecture.server.core.domain.service.model.commands.CreateTransactionCommand;
import com.hexagonal.architecture.server.shared.kernel.valueobjects.Description;
import com.hexagonal.architecture.server.shared.kernel.valueobjects.Id;
import com.hexagonal.architecture.server.shared.kernel.valueobjects.Money;
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
