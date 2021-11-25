package com.fullcycle.FCCatalogo.domain.entity;

import java.util.UUID;
import java.util.regex.Pattern;

public class BaseEntity {
    
    private UUID id;
    
    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        if (id == null) throw new IllegalArgumentException("id is marked non-null but is null");
        if (!this.isValidUUID(id.toString())) throw new IllegalArgumentException("id is marked as valid UUID but is not valid UUID");
        this.id = id;
    }

    protected UUID generateUUID() {
        this.id = UUID.randomUUID();
        return this.id;
    }

    protected Boolean isValidUUID(String _id) {
        if (_id == null) {
            return false;
        }
        Pattern UUID_REGEX_PATTERN = Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");
        return UUID_REGEX_PATTERN.matcher(_id).matches();
    }
}
