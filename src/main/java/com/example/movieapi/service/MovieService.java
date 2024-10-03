package com.example.movieapi.service;

import org.springframework.stereotype.Service;

import com.example.movieapi.entity.Movie;

@Service
public class MovieService {
   public void saveMovies(Movie movie){
    System.out.println("saving movie:" +movie.toString());
   } 
}
