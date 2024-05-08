//Purpose: This is the manager and constructor class for the list node. It constructs and then has the methods
//for modifying the list node.

import java.util.Scanner;
public class PhoneBook{
    Scanner scanner = new Scanner(System.in);
    private ListNode first;
    private ListNode last;
    public int size; // counter
  //constructor for the phone book, initializes the values as null  
    public PhoneBook() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
//defines the list node
    public class ListNode {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String phoneNumber;
        public ListNode next; // Reference to the next node in the list

        // Constructor for the list node
        public ListNode(String firstName, String lastName, String address, String city, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.phoneNumber = phoneNumber;
            this.next = null;
        }

        // Override toString method
        public String toString() {
            return "(" + this.firstName + " " + this.lastName + " | " + this.phoneNumber +
                   " | " + this.city + ", " +  this.address + ")";
        }

        // Getters
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
    
    // Method to add a new entry to the end of the list
    public void addEntry(String firstName, String lastName, String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(firstName, lastName, address, city, phoneNumber);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    
    // Method to delete an entry from the list
    public void deleteEntry(String firstName, String lastName) {
        if (first == null) {
            return;
        }
        if (first.firstName.equals(firstName) && first.lastName.equals(lastName)) {
            first = first.next;
            size--;
            return;
        }
        ListNode prev = first;
        ListNode current = first.next;
        while (current != null) {
            if (current.firstName.equals(firstName) && current.lastName.equals(lastName)) {
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    
    // Method to modify an entry
    public void modifyEntry(Scanner scanner) {
        System.out.println("Enter the first name of the entry you want to modify:");
        String oldFirstName = scanner.nextLine();
        System.out.println("Enter the last name of the entry you want to modify:");
        String oldLastName = scanner.nextLine();

        System.out.println("Enter the new first name:");
        String newFirstName = scanner.nextLine();
        System.out.println("Enter the new last name:");
        String newLastName = scanner.nextLine();
        System.out.println("Enter the new address:");
        String newAddress = scanner.nextLine();
        System.out.println("Enter the new city:");
        String newCity = scanner.nextLine();
        System.out.println("Enter the new phone number:");
        String newPhoneNumber = scanner.nextLine();

        ListNode current = first;
        while (current != null) {
            if (current.firstName.equals(oldFirstName) && current.lastName.equals(oldLastName)) {
                current.firstName = newFirstName;
                current.lastName = newLastName;
                current.address = newAddress;
                current.city = newCity;
                current.phoneNumber = newPhoneNumber;
                return;
            }
            current = current.next;
        }
        System.out.println("Entry not found.");
    }
    
    // Method to print the phone book entries
    public void printPhoneBook() {
        ListNode current = first;
        System.out.println("Phone Book Entries:");
        while (current != null) {
            System.out.println(current.toString());
            System.out.println("---------------------");
            current = current.next;
        }
    }
}