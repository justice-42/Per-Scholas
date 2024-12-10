package com.justice.musicplatform.services;

import com.justice.musicplatform.models.MusicTrack;
import com.justice.musicplatform.repositories.MusicTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for MusicTrack entity.
 */
@Service
public class MusicTrackService {

    @Autowired
    private MusicTrackRepository musicTrackRepository;

    public List<MusicTrack> getTracksByPlaylistId(Long playlistId) {
        return musicTrackRepository.findByPlaylistId(playlistId);
    }

    public MusicTrack addTrack(String title, String artist, String genre, Long playlistId) {
        MusicTrack track = new MusicTrack();
        track.setTitle(title);
        track.setArtist(artist);
        track.setGenre(genre);
        track.setPlaylistId(playlistId);
        return musicTrackRepository.save(track);
    }
}
