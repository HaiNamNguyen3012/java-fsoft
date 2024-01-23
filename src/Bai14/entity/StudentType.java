package Bai14.entity;

public enum StudentType {
    GOOD_STUDENT(1),
    NORMAL_STUDENT(2);
    private final int value;
    StudentType(int value) {this.value = value;}
    public int getValue() {
        return value;
    }
    public static StudentType getStudentTypeFromValue(int value){
        for (StudentType studentType: values()){
            if(studentType.value == value){
                return studentType;
            }
        }
        throw new IllegalArgumentException("Invalid SchoolType value: " + value);
    }
}
