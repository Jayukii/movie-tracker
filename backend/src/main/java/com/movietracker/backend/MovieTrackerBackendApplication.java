package com.movietracker.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.movietracker.backend.repository")
public class MovieTrackerBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieTrackerBackendApplication.class, args);
    }
}
