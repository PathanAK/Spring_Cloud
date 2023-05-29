package com.movie.catalog.service.Controllers;

import java.util.Arrays;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.catalog.service.model.Catalog;
import com.movie.catalog.service.model.Rating;
import com.movie.rating.service.rating.UserRating;
import com.movie.catalog.service.model.Movie;

@RestController
public class CatalogController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	  @GetMapping("/catalogs/{userId}")
	    public List<Catalog> getCatalogs(@PathVariable String userId) {
		  
		  	UserRating ratings = restTemplate.getForObject("http://localhost:9093/userRating/" + userId, UserRating.class);
		  
	        return ratings.getUserRating().stream()
	                .map(rating -> {
	                    Movie movie = restTemplate.getForObject("http://localhost:9092/info/" + rating.getMovieId(), Movie.class);
	                	return new Catalog(movie.getName(), "Test", rating.getRating());
                })
         .collect(Collectors.toList());      
	    }
} 


/*
 	        List<Catalog> catalogs = new ArrayList<>();
	        
	        
            for(Rating rating : ratings) {
	        	Movie movie = webClientBuilder.build()
            		.get()
            		.uri("http://localhost:9092/info/" + rating.getMovieId())
            		.retrieve()
            		.bodyToMono(Movie.class)
            		.block();
	        	Catalog catalog = new Catalog(movie.getName(), "Test", rating.getRating());
	            catalogs.add(catalog);
	        }
	        return catalogs;
	        
	        }
	 }
*/
