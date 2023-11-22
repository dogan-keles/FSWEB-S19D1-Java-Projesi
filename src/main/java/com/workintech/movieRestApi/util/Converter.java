package com.workintech.movieRestApi.util;

import com.workintech.movieRestApi.dto.ActorResponse;
import com.workintech.movieRestApi.dto.MovieResponse;
import com.workintech.movieRestApi.entity.Actor;
import com.workintech.movieRestApi.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static ActorResponse actorConverter(Actor actor){
        return new ActorResponse(actor.getFirstName(), actor.getLastName());
    }
    public static List<ActorResponse> actorListConverter(List<Actor> actors){
        List<ActorResponse> actorResponseList = new ArrayList<>();
        for(Actor actor : actors){
            actorResponseList.add(new ActorResponse(actor.getFirstName(), actor.getLastName()));
        }
        return actorResponseList;
    }
    public static MovieResponse movieConverter(Movie movie){
        List<ActorResponse> actorResponseList = new ArrayList<>();
        for(Actor actor : movie.getActorList()){
            actorResponseList.add(new ActorResponse(actor.getFirstName(), actor.getLastName()));
        }
        return new MovieResponse(movie.getName(), movie.getDirectorName(), movie.getRating(), actorResponseList);
    }
    public static List<MovieResponse> movieListConverter(List<Movie> movies){
        List<MovieResponse> movieResponseList = new ArrayList<>();
        for(Movie movie: movies){
            List<ActorResponse> actorResponseList = new ArrayList<>();
            for(Actor actor: movie.getActorList()){
                actorResponseList.add(new ActorResponse(actor.getFirstName(), actor.getLastName()));
            }
            movieResponseList.add(new MovieResponse(movie.getName(), movie.getDirectorName(), movie.getRating(), actorResponseList));
        }
        return movieResponseList;
    }
}
