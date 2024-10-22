package org.example.touristguide.repository;

import org.example.touristguide.model.Tag;
import org.example.touristguide.model.TouristAttraction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {
    private TouristRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveAttraction() {
        TouristAttraction t = new TouristAttraction(1L,"Saqqara",
                "Cemetry of ancient Memphis","Cairo");
        t.setTags(Arrays.asList(Tag.HISTORY,Tag.ANCIENT));
        repository.saveAttraction(t);

        List<TouristAttraction> attractions = repository.getAllAttractions();
        assertEquals(8, attractions.size()); // Tæller at vi nu har 8 attraktioner
        assertEquals("Saqqara", attractions.get(5).getName());
    }

    @Test
    void getAllAttractions() {
    }

    @Test
    void getAttractionByName() {
    }

    @Test
    void deleteAttraction() {
    }

    @Test
    void updateAttraction() {
    }

    @Test
    void getCities() {
    }

    @Test
    void getTags() {
    }
}