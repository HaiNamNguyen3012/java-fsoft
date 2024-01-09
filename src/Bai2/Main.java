package Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ManageDocument manageDocument = new ManageDocument();
        while (true){
            System.out.println("Application Manager Document");
            System.out.println("Enter 1: To add document:");
            System.out.println("Enter 2: To search document by category:");
            System.out.println("Enter 3: To show information documents:");
            System.out.println("Enter 4: To remove document by id");
            System.out.println("Enter 5: To exit the program");

            String line = scanner.nextLine();
            switch (line){
                case "1": {
                    System.out.println("Enter a: to insert book");
                    System.out.println("Enter b: to insert newspaper");
                    System.out.println("Enter c: to insert magazine");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.print("Enter ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter publisher:");
                            String publisher = scanner.nextLine();
                            System.out.print("Enter copiesPublished: ");
                            int copiesPublished = scanner.nextInt();
                            System.out.print("Enter author: ");
                            scanner.nextLine();
                            String author = scanner.nextLine();
                            System.out.print("Enter page number: ");
                            int numberOfPage = scanner.nextInt();
                            Document book = new Book(id, publisher, copiesPublished, author, numberOfPage);
                            manageDocument.addDocument(book);
                            System.out.println(book.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "b": {
                            System.out.print("Enter ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter publisher:");
                            String publisher = scanner.nextLine();
                            System.out.print("Enter copiesPublished: ");
                            int copiesPublished = scanner.nextInt();
                            System.out.println("Enter day issue");
                            int dayIssue = scanner.nextInt();
                            Document newspaper = new NewsPaper(id, publisher, copiesPublished, dayIssue);
                            manageDocument.addDocument(newspaper);
                            System.out.println(newspaper.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "c": {
                            System.out.print("Enter ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter publisher:");
                            String publisher = scanner.nextLine();
                            System.out.print("Enter copiesPublished: ");
                            int copiesPublished = scanner.nextInt();
                            System.out.print("Enter issue number : ");
                            int issueNumber = scanner.nextInt();
                            System.out.print("Enter issue month : ");
                            int issueMonth = scanner.nextInt();
                            Document magazine = new Magazine(id, publisher, copiesPublished, issueNumber, issueMonth);
                            manageDocument.addDocument(magazine);
                            System.out.println(magazine.toString());
                            scanner.nextLine();
                            break;
                        }
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                }
                case "2":{
                    System.out.println("Enter a to search book");
                    System.out.println("Enter b to search newspaper");
                    System.out.println("Enter a to search journal");
                    String choise = scanner.nextLine();
                    switch (choise) {
                        case "a": {
                            manageDocument.searchByBook();
                            break;
                        }
                        case "b": {
                            manageDocument.searchByNewsPaper();
                            break;
                        }
                        case "c":
                            manageDocument.searchByMagazine();
                            break;
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                }
                case "3": {
                    manageDocument.showInfo();
                    break;
                }
                case "4": {
                    System.out.print("Enter id to remove: ");
                    String id = scanner.nextLine();
                    System.out.println(manageDocument.deleteDocument(id) ? "Success" : "Fail");
                    break;
                }
                case "5": {
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
