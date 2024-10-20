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
    private TouristRepository repository = new TouristRepository();

    @BeforeEach
    void setUp() {
        repository = new TouristRepository();
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void getAllAttractions() {
//        List<TouristAttraction> touristAttractions = repository.getAllAttractions();
//        assertEquals(7, touristAttractions.size(), "Expected 7 attractions to be present");
//    }
//
//    @Test
//    void getAttractionByName_SUCCESS() {
//        TouristAttraction attraction = repository.getAttractionByName("Pyramids of Giza");
//        assertNotNull(attraction, "Expected attraction to be found");
//        assertEquals("Pyramids of Giza", attraction.getName(), "Attraction name mismatch");
//    }
//
//    @Test
//    void getAttractionByName_FAIL() {
//        TouristAttraction attraction = repository.getAttractionByName("KEA");
//        assertNull(attraction, "Expected no attraction to be found");
//    }
//
//    @Test
//    void updateAttraction() {
//        TouristAttraction attraction = new TouristAttraction(1L, "Pyramids of Giza", "The Great Pyramids", "Giza");
//        attraction.setDescription("A stunning view of the ancient structures.");
//        repository.updateAttraction(attraction);
//
//        TouristAttraction updatedAttraction = repository.getAttractionByName("Pyramids of Giza");
//        assertEquals("A stunning view of the ancient structures.", updatedAttraction.getDescription(), "Description should be updated");
//    }
//
//    @Test
//    void saveAttraction() {
//        TouristAttraction attraction = new TouristAttraction(2L, "The Sphinx", "A limestone statue of a reclining sphinx", "Giza");
//        attraction.setTags(Arrays.asList(Tag.HISTORY, Tag.MONUMENT));
//        repository.saveAttraction(attraction);
//
//        List<TouristAttraction> t = repository.getAllAttractions();
//        assertEquals(8, t.size(), "Expected 8 attractions after adding a new one");
//        assertEquals("The Sphinx", t.get(7).getName(), "The last attraction should be 'The Sphinx'");
//    }
//
//    @Test
//    void saveAttraction_Fail() {
//        TouristAttraction duplicateAttraction = new TouristAttraction(3L, "Pyramids of Giza", "The iconic pyramids built as tombs for ancient Pharaohs.", "Giza");
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            repository.saveAttraction(duplicateAttraction);
//        });
//
//        assertEquals("Attraction already exists", exception.getMessage(), "Expected an exception for duplicate save");
//
//        List<TouristAttraction> t = repository.getAllAttractions();
//        assertEquals(7, t.size(), "Expected 7 attractions after failed duplicate save");
//    }
////
//    @Test
//    void deleteAttraction() {
//        repository.deleteAttraction("Pyramids of Giza");
//        List<TouristAttraction> t = repository.getAllAttractions();
//        assertEquals(6, t.size(), "Expected 6 attractions after deletion");
//    }
//
//    @Test
//    void getCities() {
//        List<String> cities = repository.getCities();
//        assertEquals(4, cities.size(), "Expected 4 cities in the database"); // Update to the actual count in your setup
//        assertTrue(cities.contains("Giza"), "Expected 'Giza' to be in the cities list");
//    }
//
//    @Test
//    void getTags() {
//        List<String> tags = repository.getTags();
//        assertTrue(tags.contains("MONUMENT"), "Expected 'MONUMENT' to be in the tags");
//        assertTrue(tags.contains("HISTORY"), "Expected 'HISTORY' to be in the tags");
//    }
}