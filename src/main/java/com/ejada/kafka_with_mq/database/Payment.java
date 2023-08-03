package com.ejada.kafka_with_mq.database;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

/**
 * The Payment class represents a payment entity. It is an entity class mapped
 * to a database table using JPA annotations. This class contains properties and
 * methods related to payment information such as transaction ID, amount,
 * account number, LocalDateTime, and payment method.
 */
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID payment_id;// UUID Instead of Long
	private String transactionId;
	private Double amount;// check double wrapper class
	private String accountNumber;
	private String paymentMethod;
    @Column(columnDefinition = "DATETIME")
	private LocalDateTime timestamp;

	/**
	 * Default constructor for the Payment class.
	 */
	public Payment() {
	}

	/**
	 * Parameterized constructor for the Payment class.
	 *
	 * @param transactionId The transaction ID associated with the payment.
	 * @param amount        The amount of the payment.
	 * @param accountNumber The account number used for the payment.
	 * @param paymentMethod The payment method used for the payment.
	 */
	public Payment(String transactionId, Double amount, String accountNumber, String paymentMethod) {
		this.transactionId = transactionId;
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Callback method automatically invoked by the JPA provider before an entity is
	 * persisted. Sets the timestamp to the current date and time when the entity is
	 * being created. This method is intended for internal use by the JPA provider
	 * and should not be called directly. The timestamp field will be automatically
	 * populated with the creation time when the entity is persisted.
	 *
	 * @see LocalDateTime#now() LocalDateTime.now() method is used to capture the
	 *      current date and time.
	 * @since 1.0
	 */
	@PrePersist
	protected void onCreate() {
		timestamp = LocalDateTime.now();
	}

	/**
	 * Get the payment ID.
	 *
	 * @return The payment ID.
	 */
	public UUID getPaymentId() {
		return payment_id;
	}

	/**
	 * Set the payment ID.
	 *
	 * @param paymentId The payment ID to set.
	 */
	public void setPaymentId(UUID paymentId) {
		this.payment_id = paymentId;
	}

	/**
	 * Get the transaction ID associated with the payment.
	 *
	 * @return The transaction ID.
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Set the transaction ID associated with the payment.
	 *
	 * @param transactionId The transaction ID to set.
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Get the amount of the payment.
	 *
	 * @return The payment amount.
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Set the amount of the payment.
	 *
	 * @param amount The payment amount to set.
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Get the account number used for the payment.
	 *
	 * @return The account number.
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Set the account number used for the payment.
	 *
	 * @param accountNumber The account number to set.
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Get the payment method used for the payment.
	 *
	 * @return The payment method.
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Set the payment method used for the payment.
	 *
	 * @param paymentMethod The payment method to set.
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Generate a string representation of the Payment object.
	 *
	 * @return A string representation of the Payment object.
	 */
	@Override
	public String toString() {
		return "Payment{" + "paymentId='" + payment_id + '\'' + ", timestamp='" + timestamp + '\'' + ", transactionId='"
				+ transactionId + '\'' + ", amount=" + amount + ", accountNumber='" + accountNumber + '\''
				+ ", paymentMethod='" + paymentMethod + '\'' + '}';
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
