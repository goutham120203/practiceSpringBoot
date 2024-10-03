package com.example.movieapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieapi.entity.Movie;
import com.example.movieapi.service.MovieService;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Simple GET endpoint to test if the server is running
    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome to the Movie API!";
    }

    // Basic POST request to add movies (mocked for now)
    @PostMapping("/movies")
    public String createMovie(@RequestBody Movie movie) {
        movieService.saveMovies(movie);
        return "Movie added successfully!";
    }
}