
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook Program.");
        Contact p1 = new Contact();
        p1.setFirstName("Vedant");
        p1.setLastName("Singh");
        p1.setPhoneNumber("9694018045");
        p1.setCity("Panna");
        p1.setEmail("singhvedant1701@gmail.com");
        p1.setAddress("03 Bajarang Road, Panna");
        p1.setState("Madhya Pradesh");
        System.out.println(p1);
    }
}