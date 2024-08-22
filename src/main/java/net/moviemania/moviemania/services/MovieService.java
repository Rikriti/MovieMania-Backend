package net.moviemania.moviemania.services;

import net.moviemania.moviemania.model.Movie;
import net.moviemania.moviemania.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void saveMovies(List<Movie> movies) {
        movieRepository.saveAll(movies);
    }
}