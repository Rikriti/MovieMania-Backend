package net.moviemania.moviemania.repository;

import net.moviemania.moviemania.model.Movie;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Id> {
}