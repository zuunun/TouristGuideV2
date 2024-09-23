package org.example.touristguide.repository;

import org.example.touristguide.model.Tag;
import org.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TouristRepository {
    final private List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        TouristAttraction t1 = new TouristAttraction("Den Lille Havfrue", "En af Danmarks mest kendte monumenter ved Langelinie i København.", "Copenhagen");
        t1.setTags(Arrays.asList(Tag.MONUMENT, Tag.FAMOUS));

        TouristAttraction t2 = new TouristAttraction("Tivoli Gardens", "En ikonisk forlystelsespark midt i København.", "Copenhagen");
        t2.setTags(Arrays.asList(Tag.AMUSEMENT_PARK, Tag.FAMILY));

        TouristAttraction t3 = new TouristAttraction("Roskilde Domkirke", "Danmarks kongelige begravelseskirke, et UNESCO verdensarv.", "Roskilde");
        t3.setTags(Arrays.asList(Tag.HISTORY, Tag.UNESCO));

        TouristAttraction t4 = new TouristAttraction("LEGOLAND", "En verdensberømt temapark baseret på LEGO.", "Billund");
        t4.setTags(Arrays.asList(Tag.AMUSEMENT_PARK, Tag.FAMILY));

        TouristAttraction t5 = new TouristAttraction("Skagen", "Et smukt natursted, hvor Skagerrak og Kattegat mødes.", "Skagen");
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
