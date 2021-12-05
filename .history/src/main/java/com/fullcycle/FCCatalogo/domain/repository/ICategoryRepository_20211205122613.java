package com.fullcycle.FCCatalogo.domain.repository;

import com.fullcycle.FCCatalogo.domain.entity.Category;

public interface ICategoryRepository {

    Iterable<Category> findAllCategories();
    Category create(Category toAdd);
}
