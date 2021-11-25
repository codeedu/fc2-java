package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VideoTests {
    
    @Test
    public void throwIllegalArgumentExceptionWhenTitleIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Video(null, "", 0, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenTitleIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Video("", "", 0, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenYearLaunchedIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Video("Video 1", "", null, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenYearLaunchedIsGreaterThanToday() {
        assertThrows(IllegalArgumentException.class, () -> new Video("Video 1", "", 2009, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenYearLaunchedIsNotInRange() {
        assertThrows(IllegalArgumentException.class, () -> new Video("Video 1", "", 12, false));
    }

    @Test
    public void createVideoWithTitleAndYearLaunchedTest() {
        final Video entity = new Video("Video 1", "My Description", 2009, false);
        
        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertEquals(entity.getYearLaunched(), 2009);
        assertFalse(entity.getOpened());
		assertTrue(entity.isValidUUID(entity.getId().toString()));
    }
    
    @Test
    public void createVideoWithTitleAndYearLaunchedAndRatingAndDurationTest() {
        final Video entity = new Video("Video 1", "My Description", 2009, false, "Rating 10", 10.2f);
        
        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertEquals(entity.getYearLaunched(), 2009);
        assertFalse(entity.getOpened());
		assertTrue(entity.isValidUUID(entity.getId().toString()));
    }
        
    @Test 
    public void createVideoWithoutFileTest() {
        final Category category1 = new Category("Category 1");
        final Category category2 = new Category("Category 2");
        final Genre genre1 = new Genre("Genre 1");
        final Genre genre2 = new Genre("Genre 2");
        final CastMember castMember1 = new CastMember("Leonan");
        final CastMember castMember2 = new CastMember("Luiz");

        List<Category> categories = new ArrayList<Category>();
        categories.add(category1);
        categories.add(category2);

        List<Genre> genres = new ArrayList<Genre>();
        genres.add(genre1);
        genres.add(genre2);

        List<CastMember> castMembers = new ArrayList<CastMember>();
        castMembers.add(castMember1);
        castMembers.add(castMember2);

        assertNotNull(categories);
        assertNotNull(genres);
        assertNotNull(castMembers);

        final Video entity = new Video("Video 1", "My Description", 2009, 10.2f, categories, genres, castMembers);

        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertEquals(entity.getYearLaunched(), 2009);
        assertNotNull(entity.getCategories());
        assertNotNull(entity.getGenres());
        assertNotNull(entity.getCastMembers());
		assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void createVideoWithoutFileWithCategoriesTest() {
        final Category category1 = new Category("Category 1");
        final Category category2 = new Category("Category 2");

        List<Category> categories = new ArrayList<Category>();
        categories.add(category1);
        categories.add(category2);

        final Video entity = new Video("Video 1", "My Description", 2009, false, "Rating 10", 10.2f);
        
        entity.setCategories(categories);

        assertNotNull(categories);
        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(category1.getName(), "Category 1");
        assertEquals(category2.getName(), "Category 2");
        assertTrue(category1.isValidUUID(category1.getId().toString()));
        assertTrue(category2.isValidUUID(category2.getId().toString()));
        assertEquals(2, entity.getCategories().size());
    }

    @Test
    public void createVideoWithoutFileWithAddCategoriesTest() {
        final Category category1 = new Category("Category 1");
        final Category category2 = new Category("Category 2");

        assertNotNull(category1);
        assertNotNull(category2);
        
        final Video entity = new Video("Video 1", "My Description", 2009, false, "Rating 10", 10.2f);
        
        entity.addCategory(category1);
        entity.addCategory(category2);

        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(category1.getName(), "Category 1");
        assertEquals(category2.getName(), "Category 2");
        assertTrue(category1.isValidUUID(category1.getId().toString()));
        assertTrue(category2.isValidUUID(category2.getId().toString()));
        assertEquals(2, entity.getCategories().size());
    }

    @Test
    public void createVideoWithoutFileWithAddGenresTest() {
        final Genre genre1 = new Genre("Genre 1");
        final Genre genre2 = new Genre("Genre 2");

        assertNotNull(genre1);
        assertNotNull(genre2);
        
        final Video entity = new Video("Video 1", "My Description", 2009, false, "Rating 10", 10.2f);
        
        entity.addGenre(genre1);
        entity.addGenre(genre2);

        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(genre1.getName(), "Genre 1");
        assertEquals(genre2.getName(), "Genre 2");
        assertTrue(genre1.isValidUUID(genre1.getId().toString()));
        assertTrue(genre2.isValidUUID(genre2.getId().toString()));
        assertEquals(2, entity.getCategories().size());
    }
    
    @Test
    public void createVideoWithoutFileWithAddCastMembersTest() {
        final CastMember castMember1 = new CastMember("Leonan");
        final CastMember castMember2 = new CastMember("Luiz");

        assertNotNull(castMember1);
        assertNotNull(castMember2);
        
        final Video entity = new Video("Video 1", "My Description", 2009, false, "Rating 10", 10.2f);
        
        entity.addCastMember(castMember1);
        entity.addCastMember(castMember2);

        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(castMember1.getName(), "Leonan");
        assertEquals(castMember2.getName(), "Luiz");
        assertTrue(castMember1.isValidUUID(castMember1.getId().toString()));
        assertTrue(castMember2.isValidUUID(castMember2.getId().toString()));
        assertEquals(2, entity.getCategories().size());
    }
}
