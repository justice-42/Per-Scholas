package com.justice.musicplatform.repositories;

import com.justice.musicplatform.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for Playlist to handle database operations.
 */
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    /**
     * Finds all playlists created by a specific user.
     * @param userId The ID of the user.
     * @return A list of playlists created by the user.
     */
    List<Playlist> findByUserId(Long userId);
}
