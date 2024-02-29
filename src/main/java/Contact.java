import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contact {


    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private Integer zip;
    private String phoneNumber;
    private String email;
    private TakeInput takeInput = (String regex, boolean editing) -> {
        String input = new Scanner(System.in).nextLine();
        while ( (!editing && input.isEmpty()) || (!input.matches(regex))) {
            System.out.println("Invalid input. Please try again.");
            input = new Scanner(System.in).nextLine();
        }
        return input;
    };

    Contact() throws IllegalArgumentException {
        this.createContact();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    private void createContact() throws InputMismatchException {
        System.out.println("Enter Contact Details:");

        System.out.print("First Name: ");
        this.firstName = takeInput.takeInput("^[A-Z][a-z]{2,}$", false);

        System.out.print("Last Name: ");
        this.lastName = takeInput.takeInput("^[A-Z][a-z]{2,}$", false);

        System.out.print("Address: ");
        this.address = takeInput.takeInput(".*", false);

        System.out.print("City: ");
        this.city = takeInput.takeInput(".*", false);

        System.out.print("State: ");
        this.state = takeInput.takeInput(".*", false);

        System.out.print("Zip: ");
        this.zip = Integer.parseInt(takeInput.takeInput("^[1-9][0-9]{5}$", false));

        System.out.print("Phone Number: ");
        this.phoneNumber = takeInput.takeInput("^[0-9]{10}$", false);

        System.out.print("Email: ");
        this.email = takeInput.takeInput("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", false);

        System.out.println();
    }
    public void editContact() {
        System.out.println("Editing Contact: " + this);
        System.out.println("Enter new details (press Enter to skip):");

        System.out.print("First Name [" + this.firstName + "]: ");
        String newFirstName = takeInput.takeInput("^[A-Z][a-z]{2,}$", true);
        if (!newFirstName.isEmpty()) {
            this.firstName = newFirstName;
        }

        System.out.print("Last Name [" + this.lastName + "]: ");
        String newLastName = takeInput.takeInput("^[A-Z][a-z]{2,}$", true);
        if (!newLastName.isEmpty()) {
            this.lastName = newLastName;
        }

        System.out.print("Address [" + this.address + "]: ");
        String newAddress = takeInput.takeInput(".*", true);
        if (!newAddress.isEmpty()) {
            this.address = newAddress;
        }

        System.out.print("City [" + this.city + "]: ");
        String newCity = takeInput.takeInput(".*", true);
        if (!newCity.isEmpty()) {
            this.city = newCity;
        }

        System.out.print("State [" + this.state + "]: ");
        String newState = takeInput.takeInput(".*", true);
        if (!newState.isEmpty()) {
            this.state = newState;
        }

        System.out.print("Zip Code [" + this.zip + "]: ");
        String newZip = takeInput.takeInput("^[1-9][0-9]{5}$", true);
        if (!newZip.isEmpty()) {
            this.zip = Integer.valueOf(newZip);
        }

        System.out.print("Phone Number [" + this.phoneNumber + "]: ");
        String newPhoneNumber = takeInput.takeInput("^[0-9]{10}$", true);
        if (!newPhoneNumber.isEmpty()) {
                this.phoneNumber = newPhoneNumber;
        }

        System.out.print("Email [" + this.email + "]: ");
        String newEmail = takeInput.takeInput("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", true);
        if (!newEmail.isEmpty()) {
            this.email = newEmail;
        }

        System.out.println();
        System.out.println("Contact updated successfully.");
    }


//    public boolean saveNewContact(Contact contact, String bookName) {
////        try  {
////            Path path = Paths.get("contacts/"+bookName+"/");
////            if (!Files.exists(path)) {
////                try {
////                    Files.createDirectories(path);
////                } catch (IOException e) {
////                    e.fillInStackTrace();
////                }
////            }
////            BufferedWriter writer = new BufferedWriter(new FileWriter(path+"/"+contact.getFirstName()+contact.getLastName()+".txt"));
////            writer.write(contact.toString());
////            writer.close();
////            return true;
////        } catch (IOException e) {
////            e.fillInStackTrace();
////            return false;
////        }
//        AddressBookManager manager = new AddressBookManager();
//        return manager.insertContact(contact, bookName);
//    }
    public boolean editContact(Contact value, String folderName) {
        return false;
    }
//    public boolean save(Contact contact, String folderName) {
//        AddressBookManager manager = new AddressBookManager();
//        int contactAlreadyExist = manager.findContact(contact, folderName);
//        if (contactAlreadyExist == -1) {
//            return saveNewContact(contact, folderName);
//        } else {
//            System.out.println("Editing Contact name :" + contact.getFirstName() + " " + contact.getLastName() + " in " + folderName);
//            return editContact(contact, folderName);
//        }
//    }


    @Override
    public String toString() {
        return "First Name\t" + firstName + '\n' +
                "Last Name\t" + lastName + '\n' +
                "Address\t\t" + address + '\n' +
                "City\t\t" + city + '\n' +
                "State\t\t" + state + '\n' +
                "ZIP=\t\t" + zip + '\n' +
                "PhoneNumber\t" + phoneNumber + '\n' +
                "Email\t\t" + email;
    }
}