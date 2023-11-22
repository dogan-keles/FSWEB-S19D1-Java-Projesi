package com.workintech.movieRestApi.repository;

import com.workintech.movieRestApi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
