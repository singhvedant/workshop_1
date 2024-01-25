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

    // Search Contact by name
    private Integer findContactByName(String firstName, String lastName) {
        for (Map.Entry<Integer, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Edit contact Details
    public void editContact(String firstName, String lastName) {
        Integer contactKey = findContactByName(firstName, lastName);
        if (contactKey == null) {
            System.out.println("Contact not found.");
            return;
        }

        Contact contact = contacts.get(contactKey);

        System.out.println("Editing Contact: " + contact);
        System.out.println("Enter new details (press Enter to skip):");

        System.out.print("First Name [" + contact.getFirstName() + "]: ");
        String newFirstName = scanner.nextLine();
        if (!newFirstName.isEmpty()) {
            contact.setFirstName(newFirstName);
        }

        System.out.print("Last Name [" + contact.getLastName() + "]: ");
        String newLastName = scanner.nextLine();
        if (!newLastName.isEmpty()) {
            contact.setLastName(newLastName);
        }

        System.out.print("Address [" + contact.getAddress() + "]: ");
        String newAddress = scanner.nextLine();
        if (!newAddress.isEmpty()) {
            contact.setAddress(newAddress);
        }

        System.out.print("City [" + contact.getCity() + "]: ");
        String newCity = scanner.nextLine();
        if (!newCity.isEmpty()) {
            contact.setCity(newCity);
        }

        System.out.print("State [" + contact.getState() + "]: ");
        String newState = scanner.nextLine();
        if (!newState.isEmpty()) {
            contact.setState(newState);
        }

        System.out.print("Zip Code [" + contact.getZip() + "]: ");
        String newZip = scanner.nextLine();
        if (!newZip.isEmpty()) {
            contact.setZip(newZip);
        }

        System.out.print("Phone Number [" + contact.getPhoneNumber() + "]: ");
        String newPhoneNumber = scanner.nextLine();
        if (!newPhoneNumber.isEmpty()) {
            contact.setPhoneNumber(newPhoneNumber);
        }

        System.out.print("Email [" + contact.getEmail() + "]: ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            contact.setEmail(newEmail);
        }
        System.out.println();

        contacts.put(contactKey, contact);
        System.out.println("Contact updated successfully.");
    }
}

