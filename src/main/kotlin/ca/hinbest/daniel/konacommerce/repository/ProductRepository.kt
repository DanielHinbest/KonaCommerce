package ca.hinbest.daniel.konacommerce.repository

import ca.hinbest.daniel.konacommerce.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for accessing Product data.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2023-10-06
 */
@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    /**
     * Finds a product by its title.
     *
     * @param title The title of the product.
     * @return The product with the specified title, or null if no such product exists.
     */
    fun findByTitle(title: String): Product?
}