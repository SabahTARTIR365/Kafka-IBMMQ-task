package com.ejada.kafka_with_mq.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for accessing and managing Payment entities in the underlying database.
 * This interface extends the JpaRepository interface provided by Spring Data JPA, which
 * provides basic CRUD operations for the Payment entity.
 *
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
