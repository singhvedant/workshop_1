import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class AddressBook {
    private final HashMap<String, Contact> contacts;

    public AddressBook() {
        this.contacts = new HashMap<>();
    }

    // Add a new contact
    public void addContact(String bookName) {
        try {
            Contact contact = new Contact();
            contacts.put(bookName, contact);
            System.out.println("Contact added successfully.");
            if (contact.save(contact, bookName)) {
                System.out.println("Successfully saved");
            }
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
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println("ContactID: " + entry.getKey() + ", Contact: " + entry.getValue());
        }
    }

    // Search Contact by name
    private String findContactByName(String firstName, String lastName) {
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();
            if (contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Edit contact Details
    public void editContact(String firstName, String lastName, String bookName) {
        String contactKey = findContactByName(firstName, lastName);
        if (contactKey == null) {
            System.out.println("Contact not found.");
            return;
        }
        Contact contact = contacts.get(contactKey);
        try {
            contact.editContact();
            contact.save(contact, bookName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Contact editing suspended.");
        }
    }

    // delete contact by Name
    public void deleteContact(String firstName, String lastName) {
        String contactKey = findContactByName(firstName, lastName);
        if (contactKey == null) {
            System.out.println("Contact not found.");
            return;
        }
        Contact contact = contacts.get(contactKey);
        System.out.println("Deleting Contact: " + contact);
        contacts.remove(contactKey);
        System.out.println("Contact deleted successfully.");
    }

    public void saveAllContacts(String folderName) {
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();
            if (!contact.save(entry.getValue(), folderName)) {
                System.out.println("Failed: \n" + contact);
            }
        }
        System.out.println("Saving process completed.");
    }
}

