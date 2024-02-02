import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to AddressBook Program.");
        AddressBooks app = new AddressBooks();
        while (true) {
            System.out.println("Address books in the database:");
            System.out.println("--------------------------------");
            app.listBooks();
            System.out.println("--------------------------------");
            System.out.println("Write the name of address book to open or name a new book to create:");
            String bookName = scanner.nextLine();
            AddressBook book = app.getBook(bookName);

            String input = "";
            while (!input.equals("6")) {
                System.out.println("Please enter a command:");
                System.out.println("1. Add a new contact");
                System.out.println("2. Remove a contact");
                System.out.println("3. List all contacts");
                System.out.println("4. Edit a contact");
                System.out.println("5. Delete a contact");
                System.out.println("6. Exit the book");
                System.out.println("7. Delete the book");
                System.out.print("Enter a command: ");
                input = scanner.nextLine();

                switch (input) {
                    case "1":
                        book.addContact();
                        break;
                    case "2":
                        System.out.print("Enter Contact ID: ");
                        int contactId = Integer.parseInt(scanner.nextLine());
                        book.removeContact(contactId);
                        break;
                    case "3":
                        System.out.println("All Contacts: ");
                        book.listContacts();
                        break;
                    case "4":
                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();
                        book.editContact(firstName, lastName);
                        break;
                    case "5":
                        System.out.print("Enter First Name: ");
                        String firstName1 = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lastName1 = scanner.nextLine();
                        book.deleteContact(firstName1, lastName1);
                        break;
                    case "6":
                        break;
                    case "7":
                        System.out.println("Enter Book name to delete : " + bookName);
                        String bookName1 = scanner.nextLine();
                        if (Objects.equals(bookName1, bookName)) {
                            app.removeBook(bookName1);
                            input = "6";
                            System.out.println("Book deleted : " + bookName);
                        } else {
                            System.out.println("Book not deleted.");
                        }
                        break;
                    default:
                        System.out.println("Invalid command.");
                        break;
                }
            }
        }
    }
}