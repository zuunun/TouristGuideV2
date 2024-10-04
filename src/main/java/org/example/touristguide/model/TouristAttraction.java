package org.example.touristguide.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private List<City> cities;
    private List<Tag> tags = new ArrayList<>();

    public TouristAttraction() {

    }

    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCity(List<City> cities) {
        this.cities = cities;
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


