package com.justice.musicplatform.services;

import com.justice.musicplatform.models.Playlist;
import com.justice.musicplatform.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for Playlist entity.
 */
@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Playlist createPlaylist(String name, Long userId) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setUserId(userId);
        return playlistRepository.save(playlist);
    }

    public List<Playlist> getPlaylistsByUserId(Long userId) {
        return playlistRepository.findByUserId(userId);
    }

    public Playlist updatePlaylist(Long playlistId, String newName) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.setName(newName);
        return playlistRepository.save(playlist);
    }
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}
