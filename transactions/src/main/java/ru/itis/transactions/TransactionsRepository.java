package ru.itis.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionsRepository extends JpaRepository<MethodEntity, Long> {
    Optional<MethodEntity> findByUuid(String uuid);
}
