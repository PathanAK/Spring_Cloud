package com.movie.rating.service.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movie.rating.service.rating.Rating;
import com.movie.rating.service.rating.UserRating;

@RestController
public class RatingController {
	
	@GetMapping("/rating/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId,4);
	}
	
	
	@GetMapping("/userRating/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		List<Rating> rating = Arrays.asList(
				new Rating("223", 11),
                new Rating("656", 8));
		UserRating userRating = new UserRating();
		userRating.setUserRating(rating);

		return userRating;
	}
}
