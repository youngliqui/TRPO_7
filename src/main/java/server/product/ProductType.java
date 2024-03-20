package server.product;

import java.util.NoSuchElementException;

public enum ProductType {
    SOFA("sofa"),
    ARMCHAIR("armchair"),
    DRESSER("dresser"),
    TABLE("table"),
    CHAIR("chair"),
    OTTOMAN("ottoman"),
    CABINET("cabinet"),
    LOUNGE_CHAIR("lounge chair"),
    BENCH("bench"),
    COFFEE_TABLE("coffee table"),
    DINING_TABLE("dining table"),
    DESK("desk"),
    BOOKSHELF("bookshelf"),
    OTHER("other");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ProductType findByName(String name) throws NoSuchElementException {
        for (ProductType type : values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new NoSuchElementException("product type with name: " + name + " is not found");
    }
}
