package com.awanish.movieinfoservice.resourse;

import com.awanish.movieinfoservice.dto.Movie;
import com.awanish.movieinfoservice.dto.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieResourse {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${moviedb.api.key}")
    private String apiKey;

    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId) {

        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey, MovieSummary.class);

        return Movie.builder()
                .movieId(movieId)
                .title(movieSummary.getTitle())
                .overview(movieSummary.getOverview())
                .build();
    }
}
