package org.example.touristguide.model;

public enum City {
    CAIRO("Cairo"),
    LUXOR("Luxor"),
    ALEXANDRIA("Alexandria"),
    ASWAN("Aswan");  // Added Aswan to the enum

    private final String displayName;

    City(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
