package com.movietracker.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movietracker.backend.dto.TmdbMovieDto;
import com.movietracker.backend.model.Movie;
import com.movietracker.backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final MovieRepository movieRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TmdbService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> importPopularMovies() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey;
        String response = restTemplate.getForObject(url, String.class);

        List<Movie> imported = new ArrayList<>();

        try {
            JsonNode root = objectMapper.readTree(response);
            JsonNode results = root.get("results");

            for (JsonNode node : results) {
                TmdbMovieDto dto = objectMapper.treeToValue(node, TmdbMovieDto.class);

                Movie movie = new Movie();
                movie.setTitle(dto.getTitle());
                movie.setDescription(dto.getDescription());
                movie.setGenres(new ArrayList<>());
                movie.setPosterUrl("https://image.tmdb.org/t/p/w500" + dto.getPosterPath());
                movie.setAverageRating(dto.getAverageRating());
                movie.setReviews(new ArrayList<>());

                imported.add(movieRepository.save(movie));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imported;
    }
}
