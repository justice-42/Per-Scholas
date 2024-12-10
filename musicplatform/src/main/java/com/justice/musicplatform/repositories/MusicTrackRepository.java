package com.justice.musicplatform.repositories;

import com.justice.musicplatform.models.MusicTrack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository for MusicTrack to handle database operations.
 */
public interface MusicTrackRepository extends JpaRepository<MusicTrack, Long> {
    List<MusicTrack> findByPlaylistId(Long playlistId);
}
