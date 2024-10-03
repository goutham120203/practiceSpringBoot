package com.example.movieapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    // Simple GET endpoint to test if the server is running
    @GetMapping("/hello")
    public String sayHello() {
        return "Welcome to the Movie API!";
    }

    // Basic POST request to add movies (mocked for now)
    @PostMapping("/movies")
    public String createMovie(@RequestBody String movie) {
        // Mock behavior: Simply print the movie data and return a success message
        System.out.println("Movie received: " + movie);
        return "Movie added successfully!" +movie;
    }
}