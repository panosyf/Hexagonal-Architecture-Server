package com.hexagonal.architecture.server.infra.persistence.adapters.transaction;

import com.hexagonal.architecture.server.core.domain.domains.transaction.Transaction;
import com.hexagonal.architecture.server.core.domain.model.enums.TransactionStatusEnum;
import com.hexagonal.architecture.server.core.domain.service.ports.driven.TransactionRepositoryPort;
import com.hexagonal.architecture.server.infra.persistence.entities.TransactionEntity;
import jakarta.transaction.Transactional;
import org.springframework.core.convert.ConversionService;

import java.time.Instant;
import java.util.Optional;

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

    // TODO THIS IS TEMPORARY SEE TODO ON INTERFACE
    @Override
    public Optional<Transaction> findById(String id) {
        Optional<TransactionEntity> optionalTransactionEntity = transactionJpaRepository.findById(id);
        return optionalTransactionEntity.map(transactionEntity -> conversionService.convert(transactionEntity, Transaction.class));
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
