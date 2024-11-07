package ca.hinbest.daniel.konacommerce.model

import jakarta.persistence.*
import java.math.BigDecimal
// TODO: Define a many-to-many relationship between Product and Platform using @ManyToMany
// - Use the "Product_Platforms" join table without creating a dedicated model for it.
// - Annotate with @JoinTable in the Product entity to specify the join columns: "product_id" and "platform_id".
// - Ensure bidirectional relationship by mapping the inverse side in the Platform entity.
// - Manage associations by adding/removing platforms to a product's "platforms" set, then saving the product.
// - No need for direct CRUD operations on the Product_Platforms table; rely on ORM to handle join management.


/**
 * Represents a product entity in the KonaCommerce application.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2023-11-06
 * @property productId The unique identifier for the product.
 * @property title The title of the product.
 * @property price The price of the product.
 * @property stockQuantity The quantity of the product in stock.
 * @property description A description of the product.
 */
@Entity
@Table(name = "Products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    var productId: Long = 0,

    @Column(name = "title", nullable = false, length = 40)
    var title: String = "",

    @Column(name = "price", nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,

    @Column(name = "stock_quantity", nullable = false)
    var stockQuantity: Int = 0,

    @Column(name = "description", nullable = false)
    var description: String = "",

    @ManyToMany
    @JoinTable(
        name = "Product_Platforms",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "platform_id")]
    )
    var platforms: MutableSet<Platform> = mutableSetOf()
)