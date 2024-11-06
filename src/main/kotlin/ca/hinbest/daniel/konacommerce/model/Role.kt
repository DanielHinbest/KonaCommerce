package ca.hinbest.daniel.konacommerce.model

import jakarta.persistence.*

/**
 * Represents a role in the system.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2023-10-05
 * @property roleId The unique identifier for the role.
 * @property roleName The name of the role.
 * @property users The list of users assigned to this role.
 * @constructor Creates a new role with the specified properties.
 */
@Entity
@Table(name = "Roles")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    var roleId: Long = 0,

    @Column(name = "role_name", nullable = false, length = 15)
    var roleName: String = "",

    @OneToMany(mappedBy = "role")
    var users: MutableList<User> = mutableListOf()
)