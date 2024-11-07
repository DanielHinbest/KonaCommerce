package ca.hinbest.daniel.konacommerce.model

import jakarta.persistence.*
import java.time.LocalDateTime

/**
 * Represents a user in the system.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2023-11-06
 * @property userId The unique identifier for the user.
 * @property username The username of the user.
 * @property email The email address of the user.
 * @property passwordHash The hashed password of the user.
 * @property createdAt The timestamp when the user was created.
 * @property lastLogin The timestamp of the user's last login.
 * @property role The role assigned to the user.
 * @constructor Creates a new user with the specified properties.
 */
@Entity
@Table(name = "Users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var userId: Long = 0,

    @Column(name = "username", nullable = false, length = 40)
    var username: String = "",

    @Column(name = "email", nullable = false, unique = true, length = 255)
    var email: String = "",

    @Column(name = "password_hash", nullable = false, length = 255)
    var passwordHash: String = "",

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "last_login")
    var lastLogin: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    var role: Role
)