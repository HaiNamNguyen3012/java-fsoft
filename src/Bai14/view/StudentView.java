package Bai14.view;

import Bai13.exception.EmailException;
import Bai14.controller.StudentController;
import Bai14.controller.ValidatorController;
import Bai14.entity.GoodStudent;
import Bai14.entity.NormalStudent;
import Bai14.entity.Student;
import Bai14.entity.StudentType;
import Bai14.exception.BirthdayException;
import Bai14.exception.FullNameException;
import Bai14.exception.PhoneException;

import java.util.Scanner;

public class StudentView {
    private StudentController studentController = new StudentController();
    public void showButton(){
        System.out.println("Application Manage Student: ");
        System.out.println("Enter a: To insert ");
        System.out.println("Enter b: To search ");
        System.out.println("Enter c: To exit:");
    }
    public void insert(StudentType studentType){
        Student student = null;
        switch (studentType){
            case GOOD_STUDENT:
                student = insertGoodStudent();
                break;
            case NORMAL_STUDENT:
                student = insertNormalStudent();
                break;
        }
        try {
            checkData(student);
        } catch (BirthdayException | PhoneException | FullNameException e) {
            insert(studentType);
            return; // Added return to prevent further execution after recursive calls
        }
        this.studentController.insert(student);
    }
    private GoodStudent insertGoodStudent(){
        Scanner scanner = ScannerFactory.getScanner();
        scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter dob with format dd/mm/yyyy: ");
        String dob = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter university name: ");
        String universityName = scanner.nextLine();
        String gradeLevel = "Good student";
        System.out.print("Enter gpa: ");
        float gpa = scanner.nextFloat();
        System.out.print("Enter best reward name: ");
        String bestRewardName = scanner.nextLine();
        GoodStudent goodStudent = new GoodStudent(fullName, dob, gender, phoneNumber, universityName, gradeLevel, gpa, bestRewardName);
        return goodStudent;
    }

    private NormalStudent insertNormalStudent(){
        Scanner scanner = ScannerFactory.getScanner();
        scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter dob with format dd/mm/yyyy: ");
        String dob = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter university name: ");
        String universityName = scanner.nextLine();
        String gradeLevel = "Normal student";
        System.out.print("Enter english score: ");
        int englishScore = scanner.nextInt();
        System.out.print("Enter entry test score: ");
        float entryTestScore = scanner.nextFloat();
        NormalStudent normalStudent = new NormalStudent(fullName, dob, gender, phoneNumber, universityName, gradeLevel, englishScore, entryTestScore);
        return normalStudent;
    }


    private void checkData(Student student) throws BirthdayException, FullNameException, PhoneException{
        ValidatorController.birthdayCheck(student.getDob());
        ValidatorController.phoneCheck(student.getPhoneNumber());
        ValidatorController.nameCheck(student.getFullName());
    }
}
