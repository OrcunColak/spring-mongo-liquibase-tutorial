package com.colak.springmongotutorial.restaurant.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

@Getter
public class AuditBase {

    @CreatedDate
    private Instant createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;

    // See https://stackoverflow.com/questions/35584271/spring-data-mongodb-annotation-createddate-isnt-working-when-id-is-assigned-m
    @Version
    private Long version;
}
