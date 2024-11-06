package ca.hinbest.daniel.konacommerce.repository

import ca.hinbest.daniel.konacommerce.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for accessing User data.
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2023-10-05
 */
@Repository
interface UserRepository : JpaRepository<User, Long> {
    /**
     * Finds a user by their email address.
     *
     * @param email The email address of the user.
     * @return The user with the specified email address, or null if no such user exists.
     */
    fun findByEmail(email: String): User?
}