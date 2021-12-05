package com.fullcycle.FCCatalogo.application.web;

import com.fullcycle.FCCatalogo.application.dto.CategoryDTO;
import com.fullcycle.FCCatalogo.application.service.ICategoryService;
import com.fullcycle.FCCatalogo.domain.entity.Category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok().body(this.categoryService.findAll());
        } catch (Exception e) {

        }
        return null;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CategoryDTO toAdd) {
        try {
            System.out.println("Category - CREATE"); 
            Category category  = this.categoryService.create(toAdd);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        } catch(Exception e) {

        }
        return null;
    }
}
