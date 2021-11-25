package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GenreTests {
    
    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Genre(null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Genre(""));
    }    
        
    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNullAndCategoriesIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Genre((String) null, null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlankAndCategoriesIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Genre((String) "", null));
    }        

    @Test
    public void createGenreWithNameTest() {
        final Genre entity = new Genre("Genre 1");
        
        assertNotNull(entity);
        assertEquals(entity.getName(), "Genre 1");
		assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void createGenreWithNameAndCategoriesTest() {
        final Category category1 = new Category("Category 1");
        final Category category2 = new Category("Category 2");

        List<Category> categories = new ArrayList<Category>();
        categories.add(category1);
        categories.add(category2);

        final Genre entity = new Genre("Genre 1", categories);
        
        assertNotNull(categories);
        assertNotNull(entity);
        assertEquals(entity.getName(), "Genre 1");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(category1.getName(), "Category 1");
        assertEquals(category2.getName(), "Category 2");
        assertTrue(category1.isValidUUID(category1.getId().toString()));
        assertTrue(category2.isValidUUID(category2.getId().toString()));
        assertEquals(2, entity.getCategories().size());
    }

    @Test
    public void addCategoryToGenreTest(){
        final Genre entity = new Genre("Genre 1");
        
        assertNotNull(entity);
        assertNotNull(entity.getCategories());
        
        final Category category1 = new Category("Category 1");
        final Category category2 = new Category("Category 2");
        
        entity.addCategory(category1);
        entity.addCategory(category2);
        
        assertEquals(2, entity.getCategories().size());
    }

    @Test
    public void removeCategoryToGenreTest(){
        final Genre entity = new Genre("Genre 1");
        
        assertNotNull(entity);
        assertNotNull(entity.getCategories());
        
        final Category category1 = new Category("Category 1");
        final Category category2 = new Category("Category 2");
        
        entity.addCategory(category1);
        entity.addCategory(category2);
        
        assertEquals(2, entity.getCategories().size());
        entity.removeCategory(category1);
        assertEquals(1, entity.getCategories().size());
        entity.removeCategory(category2);
        assertEquals(0, entity.getCategories().size());
    }

}
