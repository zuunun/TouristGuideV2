package org.example.touristguide.repository;

import org.example.touristguide.model.TouristAttraction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest // Starter hele Spring-konteksten
//@Transactional
class TouristRepositoryTest {
//    private TouristRepository repository;
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void saveAttraction() {
//        // Arrange - opsætning af en ny turistattraktion
//        TouristAttraction attraction = new TouristAttraction(1L, "Saqqara",
//                "Cemetery of ancient Memphis", "Cairo");
//
//        // Act - gem attraktionen i repository
//        repository.saveAttraction(attraction);
//
//        // Assert - verificér, at attraktionen blev gemt korrekt
//        List<TouristAttraction> attractions = repository.getAllAttractions();
//        TouristAttraction savedAttraction = attractions.stream()
//                .filter(a -> "Saqqara".equals(a.getName()))
//                .findFirst()
//                .orElse(null);
//
//        assertNotNull(savedAttraction, "Attraction should be found in the database");
//        assertEquals("Saqqara", savedAttraction.getName());
//        assertEquals("Cemetery of ancient Memphis", savedAttraction.getDescription());
//        assertEquals("Cairo", savedAttraction.getCity());
//    }
//
//
//    @Test
//    void getAllAttractions() {
//    }
//
//    @Test
//    void getAttractionByName() {
//    }
//
//    @Test
//    void deleteAttraction() {
//    }
//
//    @Test
//    void updateAttraction() {
//    }
//
//    @Test
//    void getCities() {
//    }
//
//    @Test
//    void getTags() {
//    }
}