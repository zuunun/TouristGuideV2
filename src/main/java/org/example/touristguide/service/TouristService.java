package org.example.touristguide.service;

import org.example.touristguide.model.TouristAttraction;
import org.example.touristguide.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    // CREATE
    public void saveAttraction(TouristAttraction t) {
        touristRepository.saveAttraction(t);
    }

    // READ
    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public TouristAttraction getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    // DELETE
    public void deleteAttraction(String name) {
        touristRepository.deleteAttraction(name);
    }

    // UPDATE
    public void updateAttraction(TouristAttraction updatedAttraction) {
        touristRepository.updateAttraction(updatedAttraction);
    }


    public List<String> getCities() {
        return touristRepository.getCities();
    }

    public List<String> getTags() {
        return touristRepository.getTags();
    }
}
