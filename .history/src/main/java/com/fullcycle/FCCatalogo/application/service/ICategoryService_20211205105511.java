package com.fullcycle.FCCatalogo.application.service;

import java.util.Optional;
import java.util.UUID;

import com.fullcycle.FCCatalogo.domain.entity.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(UUID id);
}
