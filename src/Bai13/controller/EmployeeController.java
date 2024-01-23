package Bai13.controller;

import Bai13.entity.*;
import Bai13.view.EmployeeView;
import Bai13.view.ScannerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeController {
    private List<Employee> employees;
    EmployeeView employeeView = new EmployeeView();
    public EmployeeController(){
        this.employees = new ArrayList<>();
    }
    public void insert(Employee employee){
        this.employees.add(employee);
    }
    public Optional<Employee> findById(String id){
        return this.employees.stream().filter(employee -> employee.getId().equals(id)).findFirst();
    }
    public boolean deleteById(String id){
        Optional<Employee> employee = this.findById(id);
        if (employee.isPresent()) {
            this.employees.remove(employee.get());
            return true;
        }
        return false;
    }

    public List<Employee> findByType(EmployeeType employeeType) {
        return this.employees.stream()
                .filter(employee -> {
                    switch (employeeType) {
                        case EXPERIENCE:
                            return employee instanceof Experience;
                        case FRESHER:
                            return employee instanceof Fresher;
                        case INTERN:
                            return employee instanceof Intern;
                        default:
                            return false;
                    }
                })
                .collect(Collectors.toList());
    }
    public List<Employee> findAll() {
        return this.employees;
    }
    public void run(){
        Scanner scanner = ScannerFactory.getScanner();

        String choice;
        while (true){
            employeeView.showButton();
            choice = scanner.nextLine();
            MissonType selectedMisson = MissonType.getMissonTypeFromValue(choice);
            switch (selectedMisson){
                case INSERT: {
                    employeeView.showMisson();
                    int type = scanner.nextInt();
                    employeeView.insert(EmployeeType.getEmployeeTypeFromValue(type));
                }
                case SEARCH: {
                    employeeView.showAllEmployee();
                }
                case EXIT:{
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
