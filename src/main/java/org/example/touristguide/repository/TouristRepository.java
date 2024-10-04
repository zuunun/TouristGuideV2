package org.example.touristguide.repository;

import org.example.touristguide.model.City;
import org.example.touristguide.model.Tag;
import org.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TouristRepository {
    final private List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        TouristAttraction t1 = new TouristAttraction("Pyramids of Giza",
                "One of the Seven Wonders of the World and a symbol of ancient Egypt.",
                City.CAIRO.getDisplayName());
        t1.setTags(Arrays.asList(Tag.MONUMENT, Tag.HISTORY));

        TouristAttraction t2 = new TouristAttraction("Luxor Temple",
                "A magnificent temple dedicated to the Egyptian god Amun.",
                City.LUXOR.getDisplayName());
        t2.setTags(Arrays.asList(Tag.HISTORY, Tag.UNESCO));

        TouristAttraction t3 = new TouristAttraction("Egyptian Museum",
                "Houses many important artifacts from ancient Egypt.",
                City.CAIRO.getDisplayName());
        t3.setTags(Arrays.asList(Tag.MUSEUM, Tag.FAMOUS));

        TouristAttraction t4 = new TouristAttraction("Aswan Dam",
                "A large dam that creates a lake and controls the Nile.",
                City.ASWAN.getDisplayName());
        t4.setTags(Arrays.asList(Tag.HISTORY, Tag.NATURE));

        TouristAttraction t5 = new TouristAttraction("Red Sea",
                "A beautiful coastline and a popular diving area.",
                City.ALEXANDRIA.getDisplayName());
        t5.setTags(Arrays.asList(Tag.NATURE, Tag.BEACH));

        Collections.addAll(touristAttractions, t1, t2, t3, t4, t5);
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
