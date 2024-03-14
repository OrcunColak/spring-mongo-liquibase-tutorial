package com.colak.springmongotutorial.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    private String userName = "my-user";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        // get user from the security context
        return Optional.of(userName);
    }
}
