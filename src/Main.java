import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook Program.");
        AddressBook book1 = new AddressBook();

        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("6")){
            System.out.println("Please enter a command:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Remove a contact");
            System.out.println("3. List all contacts");
            System.out.println("4. Edit a contact");
            System.out.println("5. Delete a contact");
            System.out.println("6. Exit");
            System.out.print("Enter a command: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    book1.addContact();
                    break;
                case "2":
                    System.out.print("Enter Contact ID: ");
                    int contactId = Integer.parseInt(scanner.nextLine());
                    book1.removeContact(contactId);
                    break;
                case "3":
                    book1.listContacts();
                    break;
                case "4":
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    book1.editContact(firstName, lastName);
                    break;
                case "5":
                    System.out.print("Enter First Name: ");
                    String firstName1 = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName1 = scanner.nextLine();
                    book1.deleteContact(firstName1, lastName1);
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}