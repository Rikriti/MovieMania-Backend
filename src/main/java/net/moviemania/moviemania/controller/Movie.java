package net.moviemania.moviemania.controller;

import net.moviemania.moviemania.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api/movies")
public class Movie{

    private final RestTemplate restTemplate;
    private final MovieService movieService;

    @Autowired
    public Movie(RestTemplate restTemplate, MovieService movieService) {
        this.restTemplate = restTemplate;
        this.movieService = movieService;
    }

    @GetMapping("/populate")
    public ResponseEntity<String> populateMovies() {
        String apiUrl = "https://api.example.com/movies";  // Replace with your actual API endpoint
        ResponseEntity<Movie[]> response = restTemplate.getForEntity(apiUrl, Movie[].class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Movie[] movies = response.getBody();
            if (movies != null) {
                movieService.saveMovies(Arrays.asList(movies));
                return ResponseEntity.ok("Movies saved successfully.");
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to populate movies.");
    }
}
