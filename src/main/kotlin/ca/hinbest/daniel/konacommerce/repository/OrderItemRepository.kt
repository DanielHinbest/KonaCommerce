package ca.hinbest.daniel.konacommerce.repository

import ca.hinbest.daniel.konacommerce.model.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for accessing OrderItem data.
 *
 * @since 1.0
 * @date 2024-11-30
 */
@Repository
interface OrderItemRepository : JpaRepository<OrderItem, Long> {
    /**
     * Finds order items by their product ID.
     *
     * @param productId The product ID of the order items.
     * @return A list of order items with the specified product ID.
     */
    fun findByProductId(productId: Long): List<OrderItem>
}