import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressBookTest {
    AddressBook book = new AddressBook();

    @Test
    public void shouldCreateContact(){
        book.addContact("Test-Book");
        Assertions.assertTrue(book.numberOfContacts() > 0);
    }
}