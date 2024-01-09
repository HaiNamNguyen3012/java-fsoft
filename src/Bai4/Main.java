package Bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Town town = new Town();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            // Input foreach family

            System.out.println("Enter address:");
            scanner.nextLine();
            String address = scanner.nextLine();

            // Enter person number in family
            List<Person> persons = new ArrayList<>();
            System.out.println("Enter number person");
            int number = scanner.nextInt();
            for (int j = 0; j < number; j++) {
                System.out.println("Enter details for person " + (j + 1));
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Job: ");
                String job = scanner.nextLine();
                System.out.print("Passport: ");
                String passport = scanner.nextLine();

                Person person = new Person(name, age, job, passport);
                persons.add(person);
            }

            // After done input
            town.addFamily(new Family(persons,address ));
        }
        System.out.println("\nFamilies in the town:");
        for (Family family : town.getFamilies()) {
            System.out.println("- Address: " + family.getAddress() + ", Number of people: " + family.getPersons().size());
        }
    }
}
