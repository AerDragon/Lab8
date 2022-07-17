package collectionUsage;

import controllers.Main;
import controllers.OrganizationProp;
import data.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CollectionManipulator {

    private static ObservableList<Organization> organizations;
    private LocalDate initializationDate;
    private Map<String, String> tutorial;
    private static String currentUser;
    private String URL;

    public static String getLogin() {
        return currentUser;
    }

    private String lgn;
    private String pwd;
    private String hexPassword;
    private static Connection connection; // abstract class for connection
    private static Statement request;

    {
        organizations = FXCollections.observableArrayList();
        tutorial = new HashMap<>();
        initializationDate = LocalDate.now();
        currentUser = null;
        tutorial.put("help", " - display help for available commands");
        tutorial.put("info", " - print all elements in string representation to standard output");
        tutorial.put("add", " - add new element to the collection");
        tutorial.put("update id", " - update the element`s value, whose ID is equal to the given." +
                " You should to enter ID after entering a command.");
        tutorial.put("remove_by_id id", " - remove an element from the collection by its ID." +
                " You should to enter ID after entering a command.");
        tutorial.put("clear", " - clear the collection");
        tutorial.put("save", " - save the collection to file");
        tutorial.put("execute_script filename", " - read and execute a script from specified file." +
                " You should to enter path to file after entering a command.");
        tutorial.put("exit", " - end the program (without saving to file)");
        tutorial.put("remove_first", " - remove from collection first item");
        tutorial.put("shuffle", " - shuffle the elements of the collection randomly");
        tutorial.put("show", " - print all collection items in print representation");
        tutorial.put("sum_of_annual_turnover", " - prints sum of value of field annualTurnover in collection");
        tutorial.put("count_by_head head", " - display the number of elements whose head field value " +
                "is equal to the given one");
        tutorial.put("count_less_than_postal postalAddress", " - counts amount of items field postalAddress of which is less than a given" +
                "the given substring");
        tutorial.put("filter_by_employees_count employeesCount", " - display the elements of the collection which employeesCount field is equal for a given");
        tutorial.put("history", " - displays last 12 commands without it's arguments");
    }

    public CollectionManipulator() {
        try {
            CryptoManipulator cryptographer = new CryptoManipulator();
//            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("helios_db.properties");
//            Properties properties = System.getProperties();
//            properties.load(inputStream);

            URL = "jdbc:postgresql://localhost:5488/studs";//properties.getProperty("url_address");
            if (cryptographer.encrypt("s335027"/*properties.getProperty("user")*/)
                    .equals("8d2911d537297688bcddf2d04c356133c9285258")) {
                lgn = "s335027";//properties.getProperty("user");
            } else throw new IOException();
            if (cryptographer.encrypt("rnd557"/*properties.getProperty("password")*/)
                    .equals("b39291138716767040ba4cb3403ed201e2d5c318")) {
                pwd = "rnd557";//properties.getProperty("password");
                hexPassword = cryptographer.encrypt("rnd557"/*properties.getProperty("password")*/);
            }
            if (lgn != null && pwd != null) {
                System.out.println("Data for connection is correct.");
            } else throw new NullPointerException();
            while (true) {
                try {
                    this.connection = DriverManager.getConnection(URL, lgn, pwd);
                    this.request = connection.createStatement();
                    break;
                } catch (PSQLException psqlException) {
                    System.out.println("Database is not available at the moment therefore SSH tunnel inactive. Reconnecting...");
                } catch (SQLException sqlException) {
                    System.out.println("Database is not available at the moment. Reconnecting...");
                }
            }
            System.out.println("Connection has been established successfully.");
            System.out.println(load());
        } catch (IOException | NullPointerException exception) {
            System.out.println("Invalid data into properties file. Cannot resolve connection to database.\n" +
                    "Check properties file and try again.");
            exception.printStackTrace();
            System.exit(1);
        }
    }

    public static boolean login(String username, String password) {
        try {
            CryptoManipulator cryptographer = new CryptoManipulator();
            String login = "SELECT COUNT(*) FROM users WHERE login = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(login);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, cryptographer.encrypt(password));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int amount = resultSet.getInt(1);
            if (amount == 1) {
                System.out.println("Authorization was success! Welcome, " + username + "!");
                currentUser = username;
                return true;
            } else if (amount > 1) {
                System.out.println("Database error. Try later.");
                System.exit(1);
                return false;
            } else throw new SQLException();
        } catch (SQLException sqlException) {
            System.out.println("Incorrect login and/or password. Try again.");
            return false;
        }
    }

    public void logout() {
        System.out.println("Thanks for system using. Goodbye, " + currentUser + "!");
        currentUser = null;
    }

    public static boolean register(String login, String password) {
        System.out.println("New user registration...");
        for (; ; ) {
            try {
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Enter your login: ");
//                String login = scanner.nextLine().trim();
                if (login.equals("")) {
                    System.out.println("Login cannot be empty. Try again");
                    continue;
                }
//                System.out.print("Enter your password: ");
//                String password = scanner.nextLine();
                if (password.equals("")) {
                    System.out.println("Password cannot be empty. Try again");
                    continue;
                }
//                System.out.print("Just a moment! Enter your password again for checking: ");
//                String password2 = scanner.nextLine();
//                if (password.equals(password2)) {
                String loginFromDB = "SELECT COUNT(*) FROM users WHERE login = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(loginFromDB);
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                int amount = resultSet.getInt(1);
                if (amount == 0) {
                    String encryptedPassword = new CryptoManipulator().encrypt(password);
                    String register = "INSERT INTO users (login, password) values (?, ?)";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(register);
                    preparedStatement2.setString(1, login);
                    preparedStatement2.setString(2, encryptedPassword);
                    preparedStatement2.execute();
                    System.out.println("Registration was success! Now you can log in, using this data.");
                    return true;
                } else {
                    System.out.println("User is already exists. Try enter another login.");
                }
//                } else System.out.println("Passwords do not match. Try again.");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Login must be string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            } catch (SQLException sqlException) {
                System.out.println("Database error. Try later.");
                System.exit(1);
            }
            return false;
        }
    }

    public static String load() {
        try (ResultSet answer = connection.createStatement().
                executeQuery("SELECT * FROM organizations")) {
            organizations.clear();
            int counter = 0;
            while (answer.next()) {
                long id = answer.getLong("id");
                String name = answer.getString("name");
                Coordinates coordinates = new Coordinates(answer.getFloat("x_coord"), answer.getFloat("y_coord"));
                String date = answer.getString("creation_date");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                LocalDate creationDate = LocalDate.parse(date, formatter);
                float annualTurnover = answer.getFloat("annual_turnover");
                String fullName = answer.getString("full_name");
                long employeesCount = answer.getLong("employees_count");
                OrganizationType organizationType = OrganizationType.valueOf(answer.getString("organization_type"));
                Address postalAddress = new Address(answer.getString("street"), answer.getString("zip_code"),
                        new Location(answer.getDouble("x_location"), answer.getLong("y_location"),
                                answer.getLong("z_location")));
                String owner = answer.getString("owner");
                organizations.add(new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount,
                        organizationType, postalAddress, owner));
                counter += 1;
            }
            return "Collection was loaded. Loaded " + counter + " elements.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Collection cannot be loaded now. Please try later.";
        }
    }

    public static String save() {
        try {
            connection.setAutoCommit(false);
            request.addBatch("DELETE FROM organizations");
            for (Organization organization : organizations) {
                String insert = "INSERT INTO organizations (id, name, x_coord, y_coord, creation_date, annual_turnover, " +
                        "full_name, employees_count, organization_type, " +
                        "street, zip_code, x_location, y_location, z_location, owner) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insert);
                preparedStatement.setLong(1, organization.getId());
                preparedStatement.setString(2, organization.getName());
                preparedStatement.setFloat(3, organization.getCoordinates().getX());
                preparedStatement.setFloat(4, organization.getCoordinates().getY());
                preparedStatement.setString(5, organization.getCreationDate().toString());
                preparedStatement.setFloat(6, organization.getAnnualTurnover());
                preparedStatement.setString(7, organization.getFullName());
                preparedStatement.setLong(8, organization.getEmployeesCount());
                preparedStatement.setString(9, String.valueOf(organization.getType()));
                preparedStatement.setString(10, organization.getPostalAddress().getStreet());
                preparedStatement.setString(11, organization.getPostalAddress().getZipCode());
                preparedStatement.setDouble(12, organization.getPostalAddress().getTown().getX());
                preparedStatement.setLong(13, organization.getPostalAddress().getTown().getY());
                preparedStatement.setLong(14, organization.getPostalAddress().getTown().getZ());
                preparedStatement.setString(15, organization.getOwner());
                String msg = preparedStatement.toString();
                request.addBatch(msg);
            }
            request.executeBatch();
            connection.commit();
            return "Changes are saved successfully.";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Could not load the changes. Please try later.";
        } catch (Exception ioException) {
            return "Something bad with saving. Try again.";
        }
    }

    public void exit() {
        System.out.println("Finishing a program...");
        System.exit(0);
    }

    public String help() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : tutorial.entrySet()) {
            stringBuilder.append(entry.getKey()).append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }

    public static ObservableList<Organization> getOrganizations() {
        return organizations;
    }

    public static ObservableList<OrganizationProp> getOrganizationsProp() {
        return null;
    }

    public Map<String, String> getTutorial() {
        return tutorial;
    }

    public LocalDate getInitializationDate() {
        return initializationDate;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<String> getAllFullNames() {
        ArrayList<String> allFullNames = new ArrayList<>();
        for (Organization organization : organizations) {
            allFullNames.add(organization.getFullName());
        }
        return allFullNames;
    }

}
