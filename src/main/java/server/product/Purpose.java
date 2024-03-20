package server.product;

import java.util.NoSuchElementException;

public enum Purpose {
    BEDROOM("bedroom"),
    LIVING_ROOM("living room"),
    DINING_ROOM("dining room"),
    OFFICE("office"),
    OUTDOOR("outdoor"),
    KITCHEN("kitchen"),
    BATHROOM("bathroom"),
    KIDS_ROOM("kids room"),
    HALLWAY("hallway"),
    LIBRARY("library"),
    CLOSET("closet"),
    UTILITY_ROOM("utility room"),
    OTHER("other");

    private final String name;

    Purpose(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Purpose findByName(String name) throws NoSuchElementException {
        for (Purpose purpose : values()) {
            if (purpose.getName().equalsIgnoreCase(name)) {
                return purpose;
            }
        }
        throw new NoSuchElementException("purpose with name " + name + " is not found");
    }
}
