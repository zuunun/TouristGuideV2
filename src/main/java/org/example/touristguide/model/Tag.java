package org.example.touristguide.model;

public enum Tag {
    AMUSEMENT_PARK("Amusement Park"),
    FAMILY("Family"),
    MUSEUM("Museum"),
    NATURE("Nature"),
    HISTORY("History"),
    BEACH("Beach"),
    MONUMENT("Monument"),
    UNESCO("UNESCO World Heritage"),
    FAMOUS("Famous Landmark");



    private String displayName;

    Tag(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
