package com.justice.musicplatform.repositories;

import com.justice.musicplatform.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for User entity to handle database operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their username.
     * @param username The username of the user.
     * @return An Optional containing the user if found.
     */
    Optional<User> findByUsername(String username);

    /**
     * Checks if a username exists in the database.
     * @param username The username to check.
     * @return True if the username exists, otherwise false.
     */
    boolean existsByUsername(String username);
}
