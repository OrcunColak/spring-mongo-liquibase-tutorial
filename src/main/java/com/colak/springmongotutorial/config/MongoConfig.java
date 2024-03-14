package com.colak.springmongotutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Configuration
// The @EnableMongoAuditing annotation we defined for the MongoConfig class above will enable the
// @CreatedDate, @LastModifiedDate annotations to be activated for us.
@EnableMongoAuditing(
        auditorAwareRef = "auditorProvider",
        dateTimeProviderRef = "dateTimeProvider"
)
public class MongoConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        // Instant that is rounded to the nearest millisecond because for DB we are using TIMESTAMP(3)
        return () -> Optional.of(Instant.now().truncatedTo(ChronoUnit.MILLIS));
    }

}
