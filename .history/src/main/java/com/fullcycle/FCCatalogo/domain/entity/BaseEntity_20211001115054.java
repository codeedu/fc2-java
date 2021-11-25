package com.fullcycle.FCCatalogo.domain.entity;

import java.util.UUID;

public class BaseEntity {
    
    private UUID id;
    
    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
