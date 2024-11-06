package ca.hinbest.daniel.konacommerce.model

import jakarta.persistence.*

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