package com.fullcycle.FCCatalogo.infrastructure.mysql;

import com.fullcycle.FCCatalogo.domain.entity.Category;
import com.fullcycle.FCCatalogo.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Repository;

@Repository
public class MySQLCategoryRepositoryImpl implements ICategoryRepository {

    private SpringDataCategoryRepository springDataCategoryRepository;

    public MySQLCategoryRepositoryImpl(SpringDataCategoryRepository springDataCategoryRepository) {
        this.springDataCategoryRepository = springDataCategoryRepository;
    }

    @Override
    public Iterable<Category> findAllCategories() {
        return this.springDataCategoryRepository.findAll();
    }
    
}
