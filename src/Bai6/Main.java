package Bai6;

import java.util.Scanner;

public class Main {
    private enum Choice {
        A,
        B,
        C,
        D,
        E
    }
    public static void main(String[] args){
        run();
    }
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        StudentView view = new StudentView();
        StudentController studentController = new StudentController(view);


        Choice choice;
        while (true){
            System.out.println("Application Manage Student");
            System.out.println("Enter A: To insert student");
            System.out.println("Enter B: To show list of student");
            System.out.println("Enter C: To show students that have age equal 20");
            System.out.println("Enter D: To show students that have age equal 23 and country at DN");
            System.out.print("Enter E: To exit:");
            choice = Choice.valueOf(scanner.nextLine());
            switch (choice){
                case A:{
                    System.out.print("Enter id: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter country: ");
                    String country = scanner.nextLine();
                    System.out.print("Enter lop: ");
                    String lop = scanner.nextLine();
                    Student student = new Student(id, name, age, country,lop);
                    studentController.addStudent(student);
                    break;
                }
                case B:{
                    studentController.show();
                    break;
                }
                case C:{
                    studentController.showStudentEqual20();
                    break;
                }
                case D: {
                    System.out.println( "Number of students aged 23 and from DN:" + " " + studentController.countStudentEqual23AndCountryDN());
                    break;
                }
                case E:{
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
