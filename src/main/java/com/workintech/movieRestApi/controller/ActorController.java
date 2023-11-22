package com.workintech.movieRestApi.controller;

import com.workintech.movieRestApi.dto.ActorResponse;
import com.workintech.movieRestApi.entity.Actor;
import com.workintech.movieRestApi.entity.Movie;
import com.workintech.movieRestApi.service.ActorService;
import com.workintech.movieRestApi.service.MovieService;
import com.workintech.movieRestApi.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    private ActorService actorService;
    private MovieService movieService;
@Autowired
    public ActorController(ActorService actorService, MovieService movieService) {
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ActorResponse find(@PathVariable long id){
    return Converter.actorConverter(actorService.findById(id));
    }
    @GetMapping("/")
    public List<ActorResponse> findAll(){
    return Converter.actorListConverter(actorService.findAll());
    }

    @PostMapping("/")
    public ActorResponse save(Actor actor, Movie movie){
    actor.addMovie(movie);
    actorService.save(actor);
    return Converter.actorConverter(actor);
    }
    @DeleteMapping("/{d}")
    public ActorResponse delete(long id){
    Actor deletedActor = actorService.findById(id);
    movieService.delete(id);
    return Converter.actorConverter(deletedActor);
    }
}
