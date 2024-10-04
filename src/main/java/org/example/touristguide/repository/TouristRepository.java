package org.example.touristguide.repository;

import org.example.touristguide.model.Tag;
import org.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TouristRepository {
    final private List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        // Tourist attractions in Egypt
        TouristAttraction t1 = new TouristAttraction("Pyramids of Giza", "The iconic pyramids built as tombs for ancient Pharaohs.", "Giza");
        t1.setTags(Arrays.asList(Tag.HISTORY, Tag.UNESCO, Tag.MONUMENT));

        TouristAttraction t2 = new TouristAttraction("Egyptian Museum", "Houses an extensive collection of ancient Egyptian antiquities.", "Cairo");
        t2.setTags(Arrays.asList(Tag.MUSEUM,Tag.HISTORY,Tag.FAMOUS));

        TouristAttraction t3 = new TouristAttraction("Luxor Temple", "A large Ancient Egyptian temple complex located on the east bank of the Nile.", "Luxor");
        t3.setTags(Arrays.asList( Tag.HISTORY,Tag.TEMPLE, Tag.ANCIENT));

        TouristAttraction t4 = new TouristAttraction("The Valley of the Kings", "The burial site of many ancient Egyptian Pharaohs.", "Luxor");
        t4.setTags(Arrays.asList( Tag.HISTORY, Tag.UNESCO,Tag.TOMBS));

        TouristAttraction t5 = new TouristAttraction("Abu Simbel", "Two massive rock temples built during the reign of Pharaoh Ramses II.", "Aswan");
        t5.setTags(Arrays.asList( Tag.HISTORY,Tag.UNESCO, Tag.TEMPLE));

        TouristAttraction t6 = new TouristAttraction("Cairo Citadel", "A medieval Islamic fortification located in Cairo.", "Cairo");
        t6.setTags(Arrays.asList(Tag.HISTORY, Tag.FORTRESS, Tag.ARCHITECTURE));

        TouristAttraction t7 = new TouristAttraction("Karnak Temple", "A massive temple complex dedicated to the Theban triad of Amun, Mut, and Khonsu.", "Luxor");
        t7.setTags(Arrays.asList(Tag.HISTORY, Tag.TEMPLE, Tag.ANCIENT ));

        //add
        Collections.addAll(touristAttractions, t1, t2, t3, t4, t5, t6, t7);
    }

    // CREATE
    public void saveAttraction(TouristAttraction t) throws IllegalArgumentException {
        for(TouristAttraction existingAttraction : touristAttractions){
            if(existingAttraction.getName().equals(t.getName())){
                throw new IllegalArgumentException("Attraction already exists");
            }
        }
        touristAttractions.add(t);
    }

    // READ
    public List<TouristAttraction> getAllAttractions() {
        return touristAttractions;
    }

    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }

    // DELETE
    public void deleteAttraction(String name) {
        Iterator<TouristAttraction> iterator = touristAttractions.iterator();
        while (iterator.hasNext()) {
            TouristAttraction t = iterator.next();
            if (t.getName().equals(name)) {
                iterator.remove(); // Safe removal
                return; // Add return to exit once deleted
            }
        }
        // Handle case where the attraction is not found
        throw new NoSuchElementException("Attraction not found");
    }


    public List<String> getCities() {
        List<String> cities = new ArrayList<>();
        Collections.addAll(cities, "Aalborg", "Copenhagen", "Herning", "Holstebro", "Aarhus", "Billund");
        return cities;
    }

    public List<String> getTags() {
        List<String> tags = new ArrayList<>();
        for (TouristAttraction t : touristAttractions) {
            for (Tag tag : t.getTags()) {
                tags.add(tag.getDisplayName());
            }
        }
        return tags;
    }

    public void updateAttraction(TouristAttraction updatedAttraction) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equals(updatedAttraction.getName())) {
                attraction.setDescription(updatedAttraction.getDescription());
                attraction.setCity(updatedAttraction.getCity());
                attraction.setTags(updatedAttraction.getTags());
                return; // Add return to exit once updated
            }
        }
        // Handle case where the attraction is not found
        throw new NoSuchElementException("Attraction not found");
    }
}
