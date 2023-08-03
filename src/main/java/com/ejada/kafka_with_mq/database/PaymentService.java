package com.ejada.kafka_with_mq.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to handle payment-related operations.
 * This class provides methods to add a payment and retrieve all payments.
 */
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    /**
     * Constructs a new PaymentService with the given PaymentRepository.
     *
     * @param paymentRepository The PaymentRepository used to interact with the database.
     */
    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    /**
     * Adds a new payment to the database.
     *
     * @param payment The Payment object representing the payment to be added.
     * @return The Payment object after it has been saved to the database.
     */
    public Payment addPayment(Payment payment) {  
        return paymentRepository.save(payment);
    }

    /**
     * Retrieves all payments from the database.
     *
     * @return A list of Payment objects representing all the payments in the database.
     */
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
