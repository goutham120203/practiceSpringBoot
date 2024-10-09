package com.example.movieapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieapi.entity.Movie;
import com.example.movieapi.service.MovieService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Basic POST request to add movies
    @PostMapping("/movies")
    public String createMovie(@RequestBody Movie movie) {
        movieService.saveMovies(movie);
        return "Movie added successfully!";
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

      @PutMapping("/movies/{id}")
    public String updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);
        if (updatedMovie != null) {
            return "Movie updated successfully!";
        } else {
            return "Movie not found!";
        }
    }
}
