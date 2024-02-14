import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AddressBooks {
    private final HashMap<String, AddressBook> books;

    public AddressBooks() {
        this.books = new HashMap<>();
    }

    public void addBook(String bookName) {
        AddressBook book = new AddressBook();
        books.put(bookName, book);
    }

    public AddressBook getBook(String bookName) {
        AddressBook addressBook = books.get(bookName);
        if (addressBook == null) {
            addressBook = new AddressBook();
            books.put(bookName, addressBook);
            return addressBook;
        }
        return addressBook;
    }

    public void removeBook(String bookName) {
        AddressBook addressBook = books.get(bookName);
        if (addressBook == null) {
            System.out.println("Error : Wrong book name!");
        } else {
            books.remove(bookName);
            System.out.println("Book removed!");
        }
    }

    public void listBooks() {
        for (Map.Entry<String, AddressBook> entry : books.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public void deleteBook(String bookName) {
        AddressBook addressBook = books.get(bookName);
        if (addressBook == null) {
            System.out.println("Error : Wrong book name!");
        } else {
            books.remove(bookName);
            System.out.println("Book removed!");
        }
    }

    public void saveAndExit() {
        for (Map.Entry<String, AddressBook> entry : books.entrySet()) {
            AddressBook addressBook = entry.getValue();
            addressBook.saveAllContacts("contacts/"+entry.getKey());
        }
        System.exit(0);
    }
}