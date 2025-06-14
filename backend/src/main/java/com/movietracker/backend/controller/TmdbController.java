package com.movietracker.backend.controller;

import com.movietracker.backend.model.Movie;
import com.movietracker.backend.service.TmdbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tmdb")
public class TmdbController {

    private final TmdbService tmdbService;

    public TmdbController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping("/import-popular")
    public List<Movie> importPopularMovies() {
        return tmdbService.importPopularMovies();
    }
}
