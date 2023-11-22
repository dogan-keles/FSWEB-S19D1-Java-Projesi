package com.workintech.movieRestApi.service;

import com.workintech.movieRestApi.entity.Actor;
import com.workintech.movieRestApi.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ActorServiceImp implements ActorService {
    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImp(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if(optionalActor.isPresent()){
            return optionalActor.get();
        }
        throw new RuntimeException("Id is not exist: " + id);
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor delete(long id) {
        Actor actor = findById(id);
        actorRepository.delete(actor);
        return actor;
    }
}
