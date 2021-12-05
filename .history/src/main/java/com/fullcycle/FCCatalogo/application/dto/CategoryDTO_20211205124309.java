package com.fullcycle.FCCatalogo.application.dto;

import java.io.Serializable;
import java.util.UUID;

import com.fullcycle.FCCatalogo.domain.entity.Category;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import org.springframework.context.annotation.Configuration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Configuration
public class CategoryDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String name;
    private UUID id;

    public Category toEntity() {
        System.out.println("oioiii fdsa fdsfsd fdsfsd");
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        Category entity = mapper.map(this, Category.class);
        return entity;
    }
}
