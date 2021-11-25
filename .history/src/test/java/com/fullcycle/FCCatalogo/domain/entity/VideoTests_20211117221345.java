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
        assertThrows(IllegalArgumentException.class, () -> new Video("Video 1", "", 2042, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenYearLaunchedIsNotInRange() {
        assertThrows(IllegalArgumentException.class, () -> new Video("Video 1", "", 12, false));
    }

    @Test
    public void createVideoWithTitleAndYearLaunchedTest() {
        final Video entity = new Video("Video 1", "My Description", 2042, false);
        
        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertEquals(entity.getYearLaunched(), 2042);
        assertFalse(entity.getOpened());
		assertTrue(entity.isValidUUID(entity.getId().toString()));
    }
    
    @Test
    public void createVideoWithTitleAndYearLaunchedAndRatingAndDurationTest() {
        final Video entity = new Video("Video 1", "My Description", 2042, false, "Rating 10", 10.2f);
        
        assertNotNull(entity);
        assertEquals(entity.getTitle(), "Video 1");
        assertEquals(entity.getYearLaunched(), 2042);
        assertFalse(entity.getOpened());
		assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

}
