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

    public List<Employee> findByType(int type) {
        return this.employees.stream()
                .filter(employee -> {
                    switch (type) {
                        case 0:
                            return employee instanceof Experience;
                        case 1:
                            return employee instanceof Fresher;
                        case 2:
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
        EmployeeView employeeView = new EmployeeView();
        String choice;
        while (true){
            employeeView.showButton();
            choice = scanner.nextLine();
            switch (choice){
                case "a": {
                    System.out.println("Enter 1: To insert experience");
                    System.out.println("Enter 2: To insert fresher");
                    System.out.println("Enter 3: To insert intern");
                    int type = scanner.nextInt();
                    employeeView.insert(EmployeeType.getEmployeeTypeFromValue(type));
                }
                case "b": {
                    employeeView.showAllEmployee();
                }
                case "c":{
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
