package com.fullcycle.FCCatalogo.infrastructure.mysql;

import java.util.UUID;

import com.fullcycle.FCCatalogo.domain.entity.Category;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpringDataCategoryRepository extends PagingAndSortingRepository {
    
}
