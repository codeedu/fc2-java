package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTests {
    

    @Test
    public void createCategory() {
        final Category entity = new Category("Category");
        assertNotNull(entity);
        assertEquals(entity.getName(), "Category 1");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }
}
