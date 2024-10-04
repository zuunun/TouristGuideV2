package org.example.touristguide.model;

public enum Tag {
    AMUSEMENT_PARK("Amusement Park"),
    ARCHITECTURE("Architecture"),
    MUSEUM("Museum"),
    HISTORY("History"),
    ANCIENT("Ancient"),
    MONUMENT("Monument"),
    UNESCO("UNESCO World Heritage"),
    FAMOUS("Famous Landmark"),
    TOMBS("Tombs"),
    TEMPLE("Temple"),
    FORTRESS("Fortress");



    private final String displayName;

    Tag(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}


