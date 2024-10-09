package org.example.touristguide.repository;

import org.example.touristguide.model.Tag;
import org.example.touristguide.model.TouristAttraction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {
    private TouristRepository repository = new TouristRepository();

    @Test
    void getAllAttractions() {
        List<TouristAttraction> touristAttractions = repository.getAllAttractions();
        assertEquals(7, touristAttractions.size());
    }

    @Test
    void getAttractionByName_SUCCESS() {
        TouristAttraction attraction = repository.getAttractionByName("Pyramids of Giza");
        assertNotNull(attraction);
        assertEquals("Pyramids of Giza", attraction.getName());
    }

    @Test
    void getAttractionByName_FAIL() {
        TouristAttraction attraction = repository.getAttractionByName("KEA");
        assertNull(attraction);
    }

    @Test
    void updateAttraction() {
        TouristAttraction attraction = new TouristAttraction("Pyramids of Giza", "The Great Pyramids", "Giza");
        attraction.setDescription("A stunning view of the ancient structures.");
        repository.updateAttraction(attraction);

        TouristAttraction updatedAttraction = repository.getAttractionByName("Pyramids of Giza");
        assertEquals("A stunning view of the ancient structures.", updatedAttraction.getDescription());
    }

    @Test
    void saveAttraction() {
        TouristAttraction attraction = new TouristAttraction("The Sphinx", "A limestone statue of a reclining sphinx", "Giza");
        attraction.setTags(Arrays.asList(Tag.HISTORY, Tag.MONUMENT));
        repository.saveAttraction(attraction);

        List<TouristAttraction> t = repository.getAllAttractions();
        assertEquals(8, t.size());
        assertEquals("The Sphinx", t.get(7).getName());
    }

    @Test
    void saveAttraction_Fail() {
        // Attempting to save a duplicate attraction
        TouristAttraction duplicateAttraction = new TouristAttraction("Pyramids of Giza", "The iconic pyramids built as tombs for ancient Pharaohs.", "Giza");

        // Expecting an exception to be thrown for duplicate save
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            repository.saveAttraction(duplicateAttraction);
        });

        assertEquals("Attraction already exists", exception.getMessage());

        List<TouristAttraction> t = repository.getAllAttractions();
        assertEquals(7, t.size());
    }

    @Test
    void deleteAttraction() {
        repository.deleteAttraction("Pyramids of Giza");
        List<TouristAttraction> t = repository.getAllAttractions();
        assertEquals(6, t.size());
    }

    @Test
    void getCities() {
        List<String> cities = repository.getCities();
        assertEquals(5, cities.size());
        assertTrue(cities.contains("Cairo"));
    }

    @Test
    void getTags() {
        List<String> tags = repository.getTags();
        assertTrue(tags.contains("Monument"));
        assertTrue(tags.contains("History"));
    }
}
