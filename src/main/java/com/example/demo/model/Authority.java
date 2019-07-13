package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;


public enum Authority implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String toString() {
        return "Authority{}";
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
