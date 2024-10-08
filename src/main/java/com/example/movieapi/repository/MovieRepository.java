package com.example.movieapi.repository;

import org.springframework.stereotype.Repository;
import com.example.movieapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
