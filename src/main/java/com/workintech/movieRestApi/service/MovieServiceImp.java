package com.workintech.movieRestApi.service;

import com.workintech.movieRestApi.entity.Movie;
import com.workintech.movieRestApi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            return optionalMovie.get();
        }
       throw new RuntimeException("Id is not exist: " + id);

    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie delete(long id) {
        Movie movie = findById(id);
        movieRepository.delete(movie);
        return movie;
    }
}
