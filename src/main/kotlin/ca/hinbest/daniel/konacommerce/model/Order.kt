package ca.hinbest.daniel.konacommerce.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

/**
 * Represents an order entity in the KonaCommerce application.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2023-11-06
 * @lastModified 2024-11-23 - Added validation logic for input fields, including orderId.
 * @property orderId The unique identifier for the order.
 * @property user The user who placed the order.
 * @property totalAmount The total amount of the order.
 * @property orderDate The date and time when the order was placed.
 * @property status The current status of the order.
 * @constructor Creates a new order with the specified properties.
 */
@Entity
@Table(name = "Order")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var orderId: Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User,

    @Column(name = "total_amount", nullable = false)
    var totalAmount: BigDecimal = BigDecimal.ZERO,

    @Column(name = "order_date", nullable = false)
    var orderDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "status", nullable = false, length = 40)
    var status: String = ""
) {
    init {
        validate() // Validate initial values provided during construction
    }

    /**
     * Custom setter for orderId to enforce non-negative values.
     */
    var validatedOrderId: Long = orderId
        set(value) {
            require(value >= 0) { "Order ID must be non-negative" }
            field = value
        }

    /**
     * Custom setter for orderDate to enforce logical date values.
     */
    var validatedOrderDate: LocalDateTime = orderDate
        set(value) {
            require(value.isAfter(LocalDateTime.of(1900, 1, 1, 0, 0))) {
                "Order date must be after January 1, 1900"
            }
            field = value
        }

    /**
     * Custom setter for totalAmount to ensure it is non-negative.
     */
    var validatedTotalAmount: BigDecimal = totalAmount
        set(value) {
            require(value >= BigDecimal.ZERO) { "Total amount must be non-negative" }
            field = value
        }

    /**
     * Custom setter for status to ensure it is not blank.
     */
    var validatedStatus: String = status
        set(value) {
            require(value.isNotBlank()) { "Status cannot be blank" }
            field = value
        }

    /**
     * Ensures all fields are validated when an Order is constructed.
     */
    private fun validate() {
        require(orderId >= 0) { "Order ID must be non-negative" }
        require(totalAmount >= BigDecimal.ZERO) { "Total amount must be non-negative" }
        require(status.isNotBlank()) { "Status cannot be blank" }
        require(orderDate.isAfter(LocalDateTime.of(1900, 1, 1, 0, 0))) {
            "Order date must be after January 1, 1900"
        }
    }
}
