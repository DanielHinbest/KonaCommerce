package ca.hinbest.daniel.konacommerce.repository

import ca.hinbest.daniel.konacommerce.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByRoleName(roleName: String): Role?
}