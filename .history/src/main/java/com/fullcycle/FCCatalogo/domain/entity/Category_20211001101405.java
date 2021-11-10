package com.fullcycle.FCCatalogo.domain.entity;

import java.util.UUID;

public class Category {
    
    private UUID id;
    private String name;

    public Category() {}
    public Category(String name) {}
    public Category(UUID id, String name) {}

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("");
        if (name.length() == 0) throw new IllegalArgumentException("");
        this.name = name;
    } 
}