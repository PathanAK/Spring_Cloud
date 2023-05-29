package com.movie.info.service.movieController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movie.info.service.model.Movie;

@RestController
public class MovieControl {
	
	@GetMapping("/info/{MovieId}")
	public Movie getMovieInfo(@PathVariable String MovieId) {
		return new Movie(MovieId,"Test_demo");
	}
}
