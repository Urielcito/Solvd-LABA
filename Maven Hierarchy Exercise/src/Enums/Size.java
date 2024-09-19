package Enums;

// Moderate-sized enum with a private constructor and a public one
public enum Size {
    SMALL("Small size"), MEDIUM("Medium size"), LARGE("Large size");

    private final String description;

    Size(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Size fromString(String description) {
        for (Size size : Size.values()) {
            if (size.description.equalsIgnoreCase(description)) {
                return size;
            }
        }
        throw new IllegalArgumentException("No enum constant with description " + description);
    }
}

