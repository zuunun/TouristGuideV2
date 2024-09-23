package org.example.touristguide.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private List<Tag> tags = new ArrayList<>();

    public TouristAttraction() {

    }

    public TouristAttraction(String name, String description, String city) {
        this.name = name;
        this.description = description;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return
                name + '\'' +
                        ", " + description;
    }
}


