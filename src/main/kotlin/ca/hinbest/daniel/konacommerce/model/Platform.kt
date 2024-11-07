package ca.hinbest.daniel.konacommerce.model

import jakarta.persistence.*

/**
 * Represents a platform entity in the KonaCommerce application.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2023-11-06
 * @property platformId The unique identifier for the platform.
 * @property name The name of the platform.
 * @property products The set of products associated with this platform.
 * @constructor Creates a new platform with the specified properties.
 */
@Entity
@Table(name = "Platforms")
data class Platform(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_id")
    var platformId: Long = 0,

    @Column(name = "name", nullable = false, length = 40)
    var name: String = "",

    @ManyToMany(mappedBy = "platforms")
    var products: MutableSet<Product> = mutableSetOf()
)