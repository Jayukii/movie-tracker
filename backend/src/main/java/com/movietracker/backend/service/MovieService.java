package com.movietracker.backend.service;

import com.movietracker.backend.model.Movie;
import com.movietracker.backend.model.Review;
import com.movietracker.backend.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> searchMovies(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public Movie addReview(String movieId, Review review) {
    Movie movie = movieRepository.findById(movieId)
        .orElseThrow(() -> new RuntimeException("Movie not found"));

    if (movie.getReviews() == null) {
        movie.setReviews(new ArrayList<>());
    }

    movie.getReviews().add(review);
    return movieRepository.save(movie);
}
}
