package com.fullcycle.FCCatalogo.domain.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

enum CastMemberType {
    TYPE1(1),
    TYPE2(2);

    private Integer type;
    private final static Map values = new HashMap<>();

    private CastMemberType(Integer type) {
        this.type = type;
    }

    static {
        for (CastMemberType type: CastMemberType.values()) {
            values.put(type.type, type);
        }
    }

    public Integer getType() {
        return this.type;
    }

    public static Boolean valueOf(CastMemberType type) {
        CastMemberType castMemberType = (CastMemberType) values.get(type.type);
        if (castMemberType == null) return false;
        return true;
    }
}

public class CastMember extends BaseEntity {

    private String name;
    private CastMemberType type;

    // public CastMember() {}

    public CastMember(UUID id, String name, CastMemberType type) {
        super.setId(id);
        this.setName(name);
        this.setType(type);
    }

    public CastMember(String name) {
        super.generateUUID();
        this.setName(name);
    }    

    public CastMember(String name, CastMemberType type) {
        super.generateUUID();
        this.setName(name);
        this.setType(type);
    }    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("name is marked non-null but is null");
        if (name.length() == 0) throw new IllegalArgumentException("name is marked non-blank but is blank");
        this.name = name;
    }


    public CastMemberType getType() {
        return this.type;
    }

    public void setType(CastMemberType type) {
        System.out.println("ENUM" + type);
        if (type == null) throw new IllegalArgumentException("type is marked non-null but is null");
        if (!CastMemberType.valueOf(type)) throw new IllegalArgumentException("type is marked as valid enum but is not valid enum");
        this.type = type;
    }    
}
