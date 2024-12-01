package ca.hinbest.daniel.konacommerce.repository

import ca.hinbest.daniel.konacommerce.model.Platform
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for accessing Platform data
 *
 * @author Daniel Hinbest
 * @since 1.0
 * @date 2024-11-30
 */
@Repository
interface PlatformRepository : JpaRepository<Platform, Long> {
    /**
     * Finds a platform by its title.
     * @param name The platform name
     * @return The platform with the specified name, or null if it does not exist
      */
    fun findByName(name: String): Platform?
}