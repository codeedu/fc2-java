package com.fullcycle.FCCatalogo.domain.entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTests {
    
    @BeforeAll
    void initAll() {
        System.out.println("===== @BeforeAll ======");        
    }

    @BeforeEach
    void init() {
        System.out.println("===== @BeforeEach ======");        
    }

    @AfterEach
    void initAfter() {
        System.out.println("===== @AfterEach ======");        
    }

    @AfterAll
    void initAfterAll() {
        System.out.println("===== @AfterAll ======");        
    }
}
