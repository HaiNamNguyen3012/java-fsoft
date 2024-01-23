package Bai14.controller;

import Bai13.controller.EmployeeController;
import Bai14.entity.GoodStudent;
import Bai14.entity.NormalStudent;
import Bai14.entity.Student;

import java.util.*;

public class StudentController {
    private List<Student> students;
    public StudentController(){this.students = new ArrayList<>();}

    public void insert(Student student) {this.students.add(student);}

    // sắp xếp học sinh
    private void sortStudents(List<Student> students){
        Collections.sort(students, Comparator.comparing(Student::getFullName).thenComparing(Student::getPhoneNumber));
    }

    //chọn ứng viên trúng tuyển
    private static void recruitStudents(List<Student> students, int numOfRecruits) {
        System.out.println("\nRecruited students:");

        // Lấy danh sách sinh viên khá giỏi
        List<GoodStudent> goodStudents = new ArrayList<>();
        for (Student student : students) {
            if (student instanceof GoodStudent) {
                goodStudents.add((GoodStudent) student);
            }
        }

        // Sắp xếp danh sách sinh viên khá giỏi theo GPA và fullName
        Collections.sort(goodStudents, Comparator.comparing(GoodStudent::getGpa)
                .thenComparing(Student::getFullName));

        // Chọn ứng viên khá giỏi
        int remainingRecruits = numOfRecruits;
        for (GoodStudent goodStudent : goodStudents) {
            goodStudent.showMyInfo();
            System.out.println("============================");
            remainingRecruits--;
            if (remainingRecruits == 0) {
                break;
            }
        }

        // Nếu vẫn cần tuyển thêm, lấy ứng viên trung bình
        if (remainingRecruits > 0) {
            List<NormalStudent> normalStudents = new ArrayList<>();
            for (Student student : students) {
                if (student instanceof NormalStudent) {
                    normalStudents.add((NormalStudent) student);
                }
            }

            // Sắp xếp danh sách sinh viên trung bình theo điểm thi đầu vào và TOEIC
            Collections.sort(normalStudents, Comparator.comparing(NormalStudent::getEntryTestScore)
                    .thenComparing(NormalStudent::getEnglishScore)
                    .thenComparing(Student::getFullName));

            // Chọn ứng viên trung bình
            for (NormalStudent normalStudent : normalStudents) {
                normalStudent.showMyInfo();
                System.out.println("============================");
                remainingRecruits--;
                if (remainingRecruits == 0) {
                    break;
                }
            }
        }
    }
    public void run(){
        
    }
}
