package Bai13.view;

import Bai13.controller.EmployeeController;
import Bai13.controller.ValidatorController;
import Bai13.entity.*;
import Bai13.exception.BirthdayException;
import Bai13.exception.EmailException;
import Bai13.exception.FullNameException;
import Bai13.exception.PhoneException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class EmployeeView {
    private EmployeeController employeeController = new EmployeeController();
    public void showButton(){
        System.out.println("Application Manage Employee: ");
        System.out.println("Enter a: To insert ");
        System.out.println("Enter b: To search ");
        System.out.println("Enter c: To exit:");
    }
    public void insert(EmployeeType employeeType) {
        Employee employee = null;

        switch (employeeType) {
            case EXPERIENCE:
                employee = insertExperience();
                break;
            case FRESHER:
                employee = insertFresher();
                break;
            case INTERN:
                employee = insertIntern();
                break;
        }

        try {
            checkData(employee);
        } catch (BirthdayException | PhoneException | EmailException | FullNameException e) {
            insert(employeeType);
            return; // Added return to prevent further execution after recursive calls
        }

        this.employeeController.insert(employee);
    }
    private Experience insertExperience() {
        Experience experience = new Experience();
        Scanner scanner = ScannerFactory.getScanner();
        scanner.nextLine();
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        System.out.print("Input birthday with format (dd-mm-yyyy): ");
        String birthdayInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday = LocalDate.parse(birthdayInput, formatter);
        System.out.print("Input Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Input Email: ");
        String email = scanner.nextLine();
        return experience;
    }

    private Intern insertIntern() {

        Intern intern = new Intern();
        return intern;
    }

    private Fresher insertFresher() {
        Fresher fresher = new Fresher();
        return fresher;
    }

    public void update() {
        System.out.print("Input ID to update: ");
        String id = ScannerFactory.getScanner().nextLine();
        Optional<Employee> employee = this.employeeController.findById(id);
    }

    public void delete() {
        System.out.print("Input ID to deleet: ");
        String id = ScannerFactory.getScanner().nextLine();
        this.employeeController.deleteById(id);
    }

    public void showAllEmployee() {
        this.employeeController.findAll().forEach(Employee::showInformation);
    }

    private void checkData(Employee employee) throws BirthdayException, PhoneException, EmailException, FullNameException {
//        ValidatorController.birthdayCheck(employee.getBirthday());
        ValidatorController.phoneCheck(employee.getPhone());
        ValidatorController.emailCheck(employee.getEmail());
        ValidatorController.nameCheck(employee.getFullName());
    }
}
