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
    private final Scanner scanner;

    Contact() throws IllegalArgumentException {
        scanner = new Scanner(System.in);
        this.createContact();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    private void createContact() throws InputMismatchException {
        System.out.println("Enter Contact Details:");

        String inputBuffer;
        System.out.print("First Name: ");
        inputBuffer = scanner.nextLine();
        if (inputBuffer.isEmpty()) {
            throw new IllegalArgumentException("First Name cannot be empty.");
        }
        this.firstName = inputBuffer;

        System.out.print("Last Name: ");
        inputBuffer = scanner.nextLine();
        if (inputBuffer.isEmpty()) {
            throw new IllegalArgumentException("Last Name cannot be empty.");
        }
        this.lastName = inputBuffer;


        System.out.print("Address: ");
        this.address = scanner.nextLine();

        System.out.print("City: ");
        this.city = scanner.nextLine();

        System.out.print("State: ");
        this.state = scanner.nextLine();

        System.out.print("Zip Code: ");
        int zip = scanner.nextInt();
        if (zip < 0) {
            throw new IllegalArgumentException("Zip Code cannot be negative.");
        }
        this.zip = zip;

        System.out.print("Phone Number: ");
        String phone = scanner.next();
        if (phone.matches("[0-9]+") && (phone.length() == 10)) {
            this.phoneNumber = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }


        System.out.print("Email: ");
        String newEmail = scanner.nextLine();
        if (!newEmail.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = newEmail;
        System.out.println("Contact Created!");

        this.email = scanner.nextLine();
    }
    public void editContact() {
        System.out.println("Editing Contact: " + this);
        System.out.println("Enter new details (press Enter to skip):");

        System.out.print("First Name [" + this.firstName + "]: ");
        String newFirstName = scanner.nextLine();
        if (!newFirstName.isEmpty()) {
            this.firstName = newFirstName;
        }

        System.out.print("Last Name [" + this.lastName + "]: ");
        String newLastName = scanner.nextLine();
        if (!newLastName.isEmpty()) {
            this.lastName = newLastName;
        }

        System.out.print("Address [" + this.address + "]: ");
        String newAddress = scanner.nextLine();
        if (!newAddress.isEmpty()) {
            this.address = newAddress;
        }

        System.out.print("City [" + this.city + "]: ");
        String newCity = scanner.nextLine();
        if (!newCity.isEmpty()) {
            this.city = newCity;
        }

        System.out.print("State [" + this.state + "]: ");
        String newState = scanner.nextLine();
        if (!newState.isEmpty()) {
            this.state = newState;
        }

        System.out.print("Zip Code [" + this.zip + "]: ");
        String newZip = scanner.nextLine();
        if (!newZip.isEmpty()) {
            int zipNew = Integer.parseInt(newZip);
            if (zipNew<=0) {
                throw new IllegalArgumentException("Zip Code not valid.");
            } else {
                this.zip = Integer.valueOf(newZip);
            }
        }

        System.out.print("Phone Number [" + this.phoneNumber + "]: ");
        String newPhoneNumber = scanner.nextLine();
        if (!newPhoneNumber.isEmpty()) {
            if (newPhoneNumber.length() == 10 && newPhoneNumber.matches("[0-9]+")) {
                this.phoneNumber = newPhoneNumber;
            } else {
                throw new IllegalArgumentException("Invalid phone number");
            }
        }

        System.out.print("Email [" + this.email + "]: ");
        String newEmail = scanner.nextLine();
        if (!newEmail.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = newEmail;
        System.out.println();

        System.out.println("Contact updated successfully.");
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}