package Bai6;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private List<Student> students;
    private StudentView view;

    public StudentController(StudentView view){
        students = new ArrayList<>();
        this.view = view;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public long countStudentEqual23AndCountryDN(){
        return this.students.stream().filter(student -> student.getAge() == 23 && student.getCountry().equals("DN")).count();
    }

    public void showStudentEqual20(){
        for (Student student : students) {
            if(student.getAge() == 20){
                System.out.println(student);
            }
        }
    }

    public  void show(){
        for (Student student : students) {
            view.printStudentDetail(student.getId(), student.getName(), student.getAge(), student.getCountry(), student.getLop());
        }

    }

}
