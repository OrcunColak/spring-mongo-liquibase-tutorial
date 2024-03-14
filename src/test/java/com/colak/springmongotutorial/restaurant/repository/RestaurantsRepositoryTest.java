package com.colak.springmongotutorial.restaurant.repository;

import com.colak.springmongotutorial.config.AuditorAwareImpl;
import com.colak.springmongotutorial.restaurant.entity.Restaurants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RestaurantsRepositoryTest {

    @Autowired
    private RestaurantsRepository repository;

    @Autowired
    private AuditorAwareImpl auditorAware;

    @Test
    void save() {
        repository.deleteById("1");

        Restaurants restaurants = new Restaurants();
        restaurants.setId("1");
        restaurants.setName("restaurant1");

        Restaurants saved = repository.save(restaurants);
        String oldUserName = auditorAware.getUserName();
        assertEquals(oldUserName, saved.getCreatedBy());
        assertEquals(oldUserName, saved.getLastModifiedBy());

        // Change user
        String newUserName = "new-user";
        auditorAware.setUserName(newUserName);

        // Update the entity
        saved.setName("new restaurant");
        saved = repository.save(saved);

        // CreatedBy and LastModifiedBy have different user names
        assertEquals(oldUserName, saved.getCreatedBy());
        assertEquals(newUserName, saved.getLastModifiedBy());


    }
}
