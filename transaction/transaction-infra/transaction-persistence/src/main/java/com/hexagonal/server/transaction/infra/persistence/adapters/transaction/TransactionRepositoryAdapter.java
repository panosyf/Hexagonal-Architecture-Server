package com.hexagonal.server.transaction.infra.persistence.adapters.transaction;

import com.hexagonal.server.shared.kernel.common.valueobjects.Id;
import com.hexagonal.server.shared.kernel.common.valueobjects.Timestamp;
import com.hexagonal.server.transaction.core.domain.domains.transaction.Transaction;
import com.hexagonal.server.transaction.core.domain.enums.TransactionStatusEnum;
import com.hexagonal.server.transaction.core.domain.exceptions.elementnotfound.TransactionNotFoundException;
import com.hexagonal.server.transaction.core.domain.service.driven.TransactionRepositoryPort;
import com.hexagonal.server.transaction.infra.persistence.daos.TransactionDao;
import jakarta.transaction.Transactional;
import org.springframework.core.convert.ConversionService;

public class TransactionRepositoryAdapter implements TransactionRepositoryPort {

    private final TransactionJpaRepository transactionJpaRepository;
    private final ConversionService conversionService;

    public TransactionRepositoryAdapter(
            TransactionJpaRepository transactionJpaRepository,
            ConversionService conversionService) {
        this.transactionJpaRepository = transactionJpaRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionDao transactionDao = conversionService.convert(transaction, TransactionDao.class);
        TransactionDao persistedTransactionDao = transactionJpaRepository.save(transactionDao);
        return transactionToDomain(persistedTransactionDao);
    }

    @Override
    public Transaction findById(Id id) {
        TransactionDao transactionDao = transactionJpaRepository.findById(id.getValue())
                .orElseThrow(() -> new TransactionNotFoundException(id.getValue()));
        return transactionToDomain(transactionDao);
    }

    @Override
    @Transactional
    public Transaction updateStatus(Transaction transaction) {
        Id id = transaction.getId();
        TransactionStatusEnum status = transaction.getStatus();
        Timestamp updatedAt = transaction.getUpdatedAt();
        transactionJpaRepository.updateStatus(id.getValue(), status, updatedAt.getTime());
        return findById(id);
    }

    @Override
    public void deleteAll() {
        transactionJpaRepository.deleteAll();
    }

    private Transaction transactionToDomain(TransactionDao transactionDao) {
        return conversionService.convert(transactionDao, Transaction.class);
    }

}
