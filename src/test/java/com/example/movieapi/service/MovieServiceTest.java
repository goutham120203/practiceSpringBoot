package com.example.movieapi.service;

import com.example.movieapi.entity.Movie;
import com.example.movieapi.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveMovies() {
        // Arrange
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setDescription("A mind-bending thriller");

        when(movieRepository.save(movie)).thenReturn(movie);

        // Act
        Movie savedMovie = movieService.saveMovies(movie);

        // Assert
        assertNotNull(savedMovie);
        assertEquals("Inception", savedMovie.getTitle());
        assertEquals("A mind-bending thriller", savedMovie.getDescription());
        verify(movieRepository, times(1)).save(movie);
    }

    @Test
    public void testGetMovieById_Found() {
        // Arrange
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setDescription("A mind-bending thriller");

        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        // Act
        Movie fetchedMovie = movieService.getMovieById(1L);

        // Assert
        assertNotNull(fetchedMovie);
        assertEquals("Inception", fetchedMovie.getTitle());
        verify(movieRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetMovieById_NotFound() {
        // Arrange
        when(movieRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Movie fetchedMovie = movieService.getMovieById(1L);

        // Assert
        assertNull(fetchedMovie);
        verify(movieRepository, times(1)).findById(1L);
    }
}
