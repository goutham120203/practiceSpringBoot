package com.example.movieapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieapi.entity.Movie;
import com.example.movieapi.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    
    public Movie saveMovies(Movie movie) {
        return movieRepository.save(movie);
    }


    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
