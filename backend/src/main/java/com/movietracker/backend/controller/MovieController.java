package com.movietracker.backend.controller;

import com.movietracker.backend.model.Movie;
import com.movietracker.backend.model.Review;
import com.movietracker.backend.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String title) {
        return movieService.searchMovies(title);
    }

    @PostMapping("/{movieId}/reviews")
    public Movie addReview(@PathVariable String movieId, @RequestBody Review review) {
        return movieService.addReview(movieId, review);
    }
}
