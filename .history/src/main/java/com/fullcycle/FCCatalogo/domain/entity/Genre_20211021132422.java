package com.fullcycle.FCCatalogo.domain.entity;

import java.util.List;
import java.util.UUID;

public class Genre extends BaseEntity {
    
    private String name;
    private List<Category> categories;

    // public Genre() {}

    public Genre(String name) {
        super.generateUUID();
        this.setName(name);
    }

    public Genre(UUID id, String name) {
        super.setId(id);
        this.setName(name);
    }

    public Genre(UUID id, String name, List<Category> categories) {
        super.setId(id);
        this.setName(name);
        this.setCategories(categories);
    }
    
    public Genre(String name, List<Category> categories) {
        super.generateUUID();
        this.setName(name);
        this.setCategories(categories);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("");
        if (name.length() == 0) throw new IllegalArgumentException("");
        this.name = name;
    }    

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        if (categories == null) throw new IllegalArgumentException("");
        this.categories = categories;
    }

    public void addCategory(Category category) {
        if (category == null) throw new IllegalArgumentException("");
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        if (category == null) throw new IllegalArgumentException("");
        this.categories.removeIf(c -> this.categories.contains(category));
    }
}
