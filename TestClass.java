//Name: Evan Eggerud & Ashling Cruz
//Class: CS 145
//Source: Deitel Deitel
//Assignment: PhoneBook
//Purpose: This is the main class which allows user input which modifies the phone book list node and prints it
import java.util.Scanner;


public class TestClass{
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        //provided so there are generic options already
        phoneBook.addEntry("John", "Doe", "123 Main St", "Bellingham", "123-456-7890");
        phoneBook.addEntry("Alice", "Smith", "456 Oak Ave", "Seattle", "987-654-3210");
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add entry");
            System.out.println("2. Delete entry");
            System.out.println("3. Modify entry");
            System.out.println("4. View phone book");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter first name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter city:");
                    String city = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addEntry(firstName, lastName, address, city, phoneNumber);
                    break;
                case 2:
                    System.out.println("Enter first name of the entry to delete:");
                    String deleteFirstName = scanner.nextLine();
                    System.out.println("Enter last name of the entry to delete:");
                    String deleteLastName = scanner.nextLine();
                    phoneBook.deleteEntry(deleteFirstName, deleteLastName);
                    break;
                case 3:
                    phoneBook.modifyEntry(scanner);
                    break;
                case 4:
                    phoneBook.printPhoneBook();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}