package Bai13.entity;

public enum MissonType {
    INSERT("a"),
    SEARCH("b"),
    EXIT("c");

    private final String value;

    MissonType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MissonType getMissonTypeFromValue(String value) {
        for (MissonType missonType : values()) {
            if (missonType.value == value) {
                return missonType;
            }
        }
        throw new IllegalArgumentException("Invalid SchoolType value: " + value);
    }
}
