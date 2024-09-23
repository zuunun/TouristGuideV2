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
        assertEquals(5, touristAttractions.size());
    }


    @Test
    void getAttractionByName_SUCCES() {
        TouristAttraction attraction = repository.getAttractionByName("Tivoli Gardens");
        assertNotNull(attraction);
        assertEquals("Tivoli Gardens", attraction.getName());
    }

    @Test
    void getAttractionByName_FAIL() {
        TouristAttraction attraction = repository.getAttractionByName("KEA");
        assertNotNull(attraction);
    }

    @Test
    void updateAttraction() {
        TouristAttraction attraction = new TouristAttraction("LEGOLAND", "En verdensberømt temapark baseret på LEGO.", "Billund");
        attraction.setDescription("En ny verden");
        assertEquals("En ny verden", attraction.getDescription());
    }


    @Test
    void saveAttraction() {
        TouristAttraction attraction = new TouristAttraction("Egenskiv skov", "en stor skov", "Fyn");
        attraction.setTags(Arrays.asList(Tag.FAMOUS, Tag.HISTORY));
        repository.saveAttraction(attraction);

        List<TouristAttraction> t = repository.getAllAttractions();
        assertEquals(6, t.size());
        assertEquals("Egenskiv skov", t.get(5).getName());

    }

    @Test
    void saveAttraction_Fail(){
        TouristAttraction duplicateAttraction = new TouristAttraction("Tivoli Gardens", "En ikonisk forlystelsespark midt i København.", "Copenhagen");
        repository.saveAttraction(duplicateAttraction);

        List<TouristAttraction> t = repository.getAllAttractions();
        assertEquals(6, t.size());
    }

    @Test
    void deleteAttraction() {
        repository.deleteAttraction("Tivoli Gardens");
        List<TouristAttraction> t = repository.getAllAttractions();
        assertEquals(4, t.size());

    }

    @Test
    void getCities() {
        List<String> cities = repository.getCities();
        assertEquals(6, cities.size());
        assertTrue(cities.contains("Copenhagen"));


    }

    @Test
    void getTags() {
        List<String> tags = repository.getTags();
        assertTrue(tags.contains("Monument"));
        assertTrue(tags.contains("Family"));
    }


}