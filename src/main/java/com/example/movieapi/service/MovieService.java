package com.example.movieapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieapi.entity.Movie;
import com.example.movieapi.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public Movie saveMovies(Movie movie) {
        return movieRepository.save(movie);
    }


    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> existingMovieOptional = movieRepository.findById(id);

        if (existingMovieOptional.isPresent()) {
            Movie existingMovie = existingMovieOptional.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setDescription(updatedMovie.getDescription());
            // Add other fields that need to be updated
            return movieRepository.save(existingMovie);
        } else {
            return null; // or throw an exception, if movie not found
        }
    }
}
