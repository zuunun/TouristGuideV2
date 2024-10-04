package org.example.touristguide.service;

import org.example.touristguide.model.City;
import org.example.touristguide.model.TouristAttraction;
import org.example.touristguide.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    TouristRepository touristRepository;

    public TouristService() {
        touristRepository = new TouristRepository();
    }

    //CREATE
    public void saveAttraction(TouristAttraction t) {
        touristRepository.saveAttraction(t);
    }

    //READ
    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public TouristAttraction getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    public void deleteAttraction(String name) {
        touristRepository.deleteAttraction(name);
    }

    public List<String> getCities() {
        return touristRepository.getCities();
    }

    public List<String> getTags() {
        return touristRepository.getTags();
    }

    public void updateAttraction(TouristAttraction updatedAttraction) {
        touristRepository.updateAttraction(updatedAttraction);
    }
}
