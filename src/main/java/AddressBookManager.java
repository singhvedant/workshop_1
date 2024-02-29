import java.sql.*;

public class AddressBookManager {
    private String jdbcURL = "jdbc:mysql://localhost:3306/AddressBookDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root-user";

    // SQL queries
    private static final String INSERT_ADDRESSBOOK_SQL = "INSERT INTO ADDRESSBOOKS (BookName) VALUES (?, 'Address-book made by admin');";
    private static final String INSERT_CONTACTS_SQL = "INSERT INTO Contacts (FirstName, LastName, PhoneNumber, Email, Address, AddressBookName) VALUES (?, ?, ?, ?, ?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertAddressBook(Contact contact, String bookName) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESSBOOK_SQL)
        ) {
            preparedStatement.setString(1, bookName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean insertContact(Contact contact, String bookName) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTACTS_SQL);
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getPhoneNumber());
            preparedStatement.setString(4, contact.getEmail());
            preparedStatement.setString(5, contact.getAddress());
            preparedStatement.setString(6, bookName);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            printSQLException(e);
            return false;
        }
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
