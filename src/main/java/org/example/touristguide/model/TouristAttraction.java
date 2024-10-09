package org.example.touristguide.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private Long attractionId;
    private String name;
    private String description;
    private String city;
    private List<Tag> tags;

    // Default constructor
    public TouristAttraction() {
    }

    // Parameterized constructor
    public TouristAttraction(String name, String description, String city) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = new ArrayList<>();

    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}


