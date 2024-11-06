package ca.hinbest.daniel.konacommerce.model

import jakarta.persistence.*
import java.time.LocalDateTime

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