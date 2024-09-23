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
        assertEquals(5,touristAttractions.size());
    }


    @Test
    void getAttractionByName_SUCCES() {
    }

    @Test
    void getAttractionByName_FAIL() {
    }

    @Test
    void saveAttraction() {

    }

    @Test
    void deleteAttraction() {
    }

    @Test
    void getCities() {
    }

    @Test
    void getTags() {
    }

    @Test
    void updateAttraction() {
    }
}