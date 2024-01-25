
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook Program.");
        AddressBook book1 = new AddressBook();
        book1.addContact();
        book1.listContacts();
        book1.editContact("vedant", "singh");
        System.out.println();
        book1.deleteContact("vedant", "singh");
    }
}