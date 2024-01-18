package Bai13.entity;

public enum EmployeeType {
    STUDENT(1),
    TEACHER(2),
    SUPPORTER(3);

    private final int value;

    EmployeeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EmployeeType getEmployeeTypeFromValue(int value) {
        for (EmployeeType employeeType : values()) {
            if (employeeType.value == value) {
                return employeeType;
            }
        }
        throw new IllegalArgumentException("Invalid SchoolType value: " + value);
    }

}
