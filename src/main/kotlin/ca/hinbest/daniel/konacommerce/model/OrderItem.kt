package ca.hinbest.daniel.konacommerce.model

import jakarta.persistence.*
import java.math.BigDecimal

/**
 * Represents an order item entity in the KonaCommerce application.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2023-11-06
 * @property orderItemId The unique identifier for the order item.
 * @property order The order to which this item belongs.
 * @property product The product that is being ordered.
 * @property quantity The quantity of the product ordered.
 * @property price The price of the product at the time of order.
 * @constructor Creates a new order item with the specified properties.
 */
@Entity
@Table(name = "Order_Items")
data class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    var orderItemId: Int = 0,

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    var order: Order,

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product,

    @Column(name = "quantity", nullable = false)
    var quantity: Int = 0,

    @Column(name = "price", nullable = false)
    var price: BigDecimal = BigDecimal.ZERO
)