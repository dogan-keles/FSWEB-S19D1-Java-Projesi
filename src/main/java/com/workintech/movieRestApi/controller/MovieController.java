package com.workintech.movieRestApi.controller;

import com.workintech.movieRestApi.dto.MovieResponse;
import com.workintech.movieRestApi.entity.Actor;
import com.workintech.movieRestApi.entity.Movie;
import com.workintech.movieRestApi.service.ActorService;
import com.workintech.movieRestApi.service.MovieService;
import com.workintech.movieRestApi.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;
    private ActorService actorService;

    @Autowired
    public MovieController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @GetMapping("/{id}")
    public MovieResponse find(@PathVariable long id) {
        return Converter.movieConverter(movieService.findById(id));
    }

    @GetMapping("/")
    public List<MovieResponse> findAll() {
        return Converter.movieListConverter(movieService.findAll());
    }

    @PostMapping("/")
    public MovieResponse save(Movie movie, Actor actor) {
        movie.addActor(actor);
        movieService.save(movie);
        return Converter.movieConverter(movie);
    }

    @DeleteMapping("/{id}")
    public MovieResponse delete(long id){
        Movie deletedMovie = movieService.findById(id);
        movieService.delete(id);
        return Converter.movieConverter(deletedMovie);
    }
}
