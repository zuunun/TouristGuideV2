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

//    @Test
//    void saveAttraction() {
//        // Arrange
//        TouristAttraction t = new TouristAttraction(1L, "Saqqara",
//                "Cemetery of ancient Memphis", "Cairo");
//        t.setTags(Arrays.asList(Tag.HISTORY, Tag.ANCIENT));
//
//        // Act
//        repository.saveAttraction(t);
//
//        // Assert
//        List<TouristAttraction> attractions = repository.getAllAttractions();
//
//        // Kontrollerer, at antallet af attraktioner er steget med 1
//        assertEquals(8, attractions.size(), "Expected 8 attractions in the database");
//
//        //
//        TouristAttraction savedAttraction = attractions.get(attractions.size() - 1);
//        assertEquals("Saqqara", savedAttraction.getName(), "Expected the last attraction's name to be 'Saqqara'");
//    }


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