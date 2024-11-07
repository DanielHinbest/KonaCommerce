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
)