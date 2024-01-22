package Bai13;

import Bai13.controller.EmployeeController;
import Bai13.entity.EmployeeType;
import Bai13.view.EmployeeView;
import Bai13.view.ScannerFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        employeeController.run();
    }
}
