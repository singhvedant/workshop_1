import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class AddressBook {
    private final HashMap<Integer, Contact> contacts;
    private int counter;

    public AddressBook() {
        this.contacts = new HashMap<>();
        this.counter = 1; // Start the counter from 1
    }

    // Add a new contact
    public void addContact() {
        try {
            Contact contact = new Contact();
            contacts.put(counter++, contact);
            System.out.println("Contact added successfully.");
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("Contact creation suspended.");
        }
    }

    // Remove a contact by key
    public void removeContact(int contactId) {
        contacts.remove(contactId);
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
        try {
            contact.editContact();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Contact editing suspended.");
        }
    }

    // delete contact by Name
    public void deleteContact(String firstName, String lastName) {
        Integer contactKey = findContactByName(firstName, lastName);
        if (contactKey == null) {
            System.out.println("Contact not found.");
            return;
        }

        Contact contact = contacts.get(contactKey);
        System.out.println("Deleting Contact: " + contact);
        contacts.remove(contactKey);
        System.out.println("Contact deleted successfully.");
    }
}

