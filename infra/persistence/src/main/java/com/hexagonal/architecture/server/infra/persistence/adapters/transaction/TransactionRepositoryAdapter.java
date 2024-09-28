package com.hexagonal.architecture.server.infra.persistence.adapters.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.exceptions.notfound.TransactionNotFoundException;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.architecture.server.infra.persistence.entities.TransactionEntity;
import jakarta.transaction.Transactional;
import org.springframework.core.convert.ConversionService;

import java.time.Instant;

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
        TransactionEntity transactionEntity = conversionService.convert(transaction, TransactionEntity.class);
        TransactionEntity persistedTransactionEntity = transactionJpaRepository.save(transactionEntity);
        return conversionService.convert(persistedTransactionEntity, Transaction.class);
    }

    @Override
    public Transaction findById(String id) {
        TransactionEntity transactionEntity = transactionJpaRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
        return conversionService.convert(transactionEntity, Transaction.class);
    }

    @Override
    @Transactional
    public void updateStatus(Transaction transaction) {
        String id = transaction.getId();
        TransactionStatusEnum status = transaction.getStatus();
        Instant updatedAt = transaction.getUpdatedAt();
        transactionJpaRepository.updateStatus(id, status, updatedAt);
    }

    @Override
    public void deleteAll() {
        transactionJpaRepository.deleteAll();
    }

}
