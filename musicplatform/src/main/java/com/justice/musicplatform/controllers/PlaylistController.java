package com.justice.musicplatform.controllers;

import com.justice.musicplatform.models.MusicTrack;
import com.justice.musicplatform.models.Playlist;
import com.justice.musicplatform.services.MusicTrackService;
import com.justice.musicplatform.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to handle requests related to playlists.
 */
@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;
    private MusicTrackService musicTrackService;

    @GetMapping("/user/{userId}")
    public String getPlaylistsByUser(@PathVariable Long userId, Model model) {
        List<Playlist> playlists = playlistService.getPlaylistsByUserId(userId);
        model.addAttribute("playlists", playlists);
        model.addAttribute("userId", userId);
        return "playlists_by_user"; // Corresponds to playlists_by_user.html
    }
    @GetMapping("/playlist/{playlistId}")
    public String getTracksByPlaylist(@PathVariable Long playlistId, Model model) {
        List<MusicTrack> tracks = musicTrackService.getTracksByPlaylistId(playlistId);
        model.addAttribute("tracks", tracks);
        model.addAttribute("playlistId", playlistId);
        return "tracks_by_playlist"; // Corresponds to tracks_by_playlist.html
    }

    @PostMapping
    public String createPlaylist(@RequestParam String name, @RequestParam Long userId) {
        playlistService.createPlaylist(name, userId);
        return "redirect:/playlists/user/" + userId;
    }

    @PostMapping("/edit")
    public String editPlaylist(@RequestParam Long playlistId, @RequestParam String newName) {
        Playlist playlist = playlistService.updatePlaylist(playlistId, newName);
        return "redirect:/playlists/user/" + playlist.getUserId();
    }
    @GetMapping("/delete/{id}/{userId}")
    public String deletePlaylist(@PathVariable Long id, @PathVariable Long userId) {
        playlistService.deletePlaylist(id);
        return "redirect:/playlists/user/" + userId;
    }
}
