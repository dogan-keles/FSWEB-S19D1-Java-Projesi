package com.workintech.movieRestApi.repository;

import com.workintech.movieRestApi.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
