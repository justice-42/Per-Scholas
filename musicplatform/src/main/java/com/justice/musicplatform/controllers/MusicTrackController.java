package com.justice.musicplatform.controllers;

import com.justice.musicplatform.models.Genre;
import com.justice.musicplatform.models.MusicTrack;
import com.justice.musicplatform.services.GenreService;
import com.justice.musicplatform.services.MusicTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/music-tracks")
public class MusicTrackController {

    @Autowired
    private MusicTrackService musicTrackService;

    @Autowired
    private GenreService genreService; // Add genreService to fetch genres

    @GetMapping("/playlist/{playlistId}")
    public String getTracksByPlaylist(@PathVariable Long playlistId, Model model) {
        List<MusicTrack> tracks = musicTrackService.getTracksByPlaylistId(playlistId);
        model.addAttribute("tracks", tracks);
        model.addAttribute("playlistId", playlistId);

        // Fetch the list of genres from the database
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);

        return "tracks_by_playlist";
    }

    @PostMapping
    public String addTrack(@RequestParam String title,
                           @RequestParam String artist,
                           @RequestParam String genre,  // The genre chosen from dropdown
                           @RequestParam Long playlistId) {
        musicTrackService.addTrack(title, artist, genre, playlistId);
        return "redirect:/music-tracks/playlist/" + playlistId;
    }
}
