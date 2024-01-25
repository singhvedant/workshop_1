import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private final HashMap<Integer, Contact> contacts;
    private int counter;
    private final Scanner scanner;

    public AddressBook() {
        this.contacts = new HashMap<>();
        this.counter = 1; // Start the counter from 1
        this.scanner = new Scanner(System.in);
    }

    // Add a new contact
    public void addContact() {
        System.out.println("Enter Contact Details:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("State: ");
        String state = scanner.nextLine();

        System.out.print("Zip Code: ");
        String zip = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZip(zip);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);

        contacts.put(counter++, contact);
        System.out.println("Contact added successfully.");
    }

    // Remove a contact by key
    public void removeContact(int contactId) {
        contacts.remove(contactId);
    }

    // Get a contact by key
    public Contact getContact(int contactId) {
        return contacts.get(contactId);
    }

    // List all contacts
    public void listContacts() {
        for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {
            System.out.println("ContactID: " + entry.getKey() + ", Contact: " + entry.getValue());
        }
    }

}

