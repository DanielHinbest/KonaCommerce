package ca.hinbest.daniel.konacommerce.repository

import ca.hinbest.daniel.konacommerce.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for accessing Role data.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2024-10-05
 */
@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    /**
     * Finds a role by its name.
     *
     * @param roleName The name of the role.
     * @return The role with the specified name, or null if no such role exists.
     */
    fun findByRoleName(roleName: String): Role?
}