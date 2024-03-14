package com.colak.springmongotutorial.restaurant.repository;

import com.colak.springmongotutorial.restaurant.entity.Restaurants;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantsRepository extends MongoRepository<Restaurants, String> {
}
