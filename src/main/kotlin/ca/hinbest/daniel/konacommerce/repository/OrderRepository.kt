package ca.hinbest.daniel.konacommerce.repository

import ca.hinbest.daniel.konacommerce.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for accessing Order data.
 *
 * @since 1.0
 * @date 2024-11-30
 */
@Repository
interface OrderRepository : JpaRepository<Order, Long> {
    /**
     * Finds orders by their status.
     *
     * @param status The status of the orders.
     * @return A list of orders with the specified status.
     */
    fun findByStatus(status: String): List<Order>
}