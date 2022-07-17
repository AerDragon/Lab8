package collectionUsage;

import data.*;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.*;

public class ValueReceiver {

    private CollectionManipulator collectionManipulator;

    public ValueReceiver(CollectionManipulator collectionManipulator) {
        this.collectionManipulator = collectionManipulator;
    }

    public long receiveId() {
        ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
        if (organizations.isEmpty()) return 1;
        long maxId = -1;
        for (Organization organization : organizations) {
            if (organization.getId() > maxId) {
                maxId = organization.getId();
            }
        }
        return maxId + 1;
    }

    public String receiveName() {
        for ( ; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name: ");
                String name = scanner.nextLine().trim();
                if (name.equals("")) {
                    System.out.println("This value cannot be empty. Try again");
                    continue;
                }
                return name;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public Float receiveX() {
        for ( ; ; ) {
            try {
                System.out.print("Enter X coordinate. Max value is 754. ");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Value cannot be empty: ");
                float x = scanner.nextFloat();
                String xx = Float.toString(x);
                if (x > 754) {
                    System.out.println("Max value is 754. Try again. ");
                    continue;
                }
                if (xx.equals("") ) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return x;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a float-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    public float receiveY() {
        for ( ; ; ) {
            try {
                System.out.print("Enter Y coordinate: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextFloat();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a float-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public Coordinates receiveCoordinates() {
        return new Coordinates(receiveX(), receiveY());
    }

    public LocalDate receiveDate() {
        return LocalDate.now();
    }

    public Float receiveAnnualTurnover() {
        for ( ; ; ) {
            try {
                System.out.print("Enter annual turnover. ");
                Scanner scanner = new Scanner(System.in);
                System.out.print("It is positive value: ");
                float annual = scanner.nextFloat();
                String xx = Float.toString(annual);
                if (annual <= 0) {
                    System.out.println("Value must be positive. Try again.");
                    continue;
                }
                if (xx.equals("") ) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return annual;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a float-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    public String receiveFullName() {
        for ( ; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name: ");
                String name = scanner.nextLine().trim();
                if (name.equals("")) {
                    System.out.println("This value cannot be empty. Try again.");
                    continue;
                }
                if (collectionManipulator.getAllFullNames().contains(name)) {
                    System.out.println("String must be unique. Try again.");
                    continue;
                }
                if (name.length() >= 1688) {
                    System.out.println("Max string length is 1688. Try again.");
                    continue;
                }
                return name;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public long receiveEmployeesCount() {
        for ( ; ; ) {
            try {
                System.out.print("Enter count of employees. ");
                Scanner scanner = new Scanner(System.in);
                System.out.print("It is positive value: ");
                long count = scanner.nextLong();
                String xx = Float.toString(count);
                if (count <= 0) {
                    System.out.println("Value must be positive. Try again.");
                    continue;
                }
                if (xx.equals("") ) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return count;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(1);
            }
        }
    }

    public OrganizationType receiveOrganizationType() {
        for ( ; ; ) {
            try {
                System.out.println("Choose organization type. Choose it from this list: ");
                System.out.print("COMMERCIAL, GOVERNMENT, OPEN_JOINT_STOCK_COMPANY");
                Scanner scanner = new Scanner(System.in);
                String choose = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
                switch (choose) {
                    case "COMMERCIAL":
                        return OrganizationType.COMMERCIAL;
                    case "GOVERNMENT":
                        return OrganizationType.GOVERNMENT;
                    case "OPEN_JOINT_STOCK_COMPANY":
                        return OrganizationType.OPEN_JOINT_STOCK_COMPANY;
                    default:
                        break;
                }
                System.out.println("Your choose must be from list. Try again.");
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Your choose must be from list. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(0);
            }
        }
    }

    public String receiveStreet() {
        for ( ; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a street: ");
                String name = scanner.nextLine().trim();
                if (name.equals("")) {
                    System.out.println("This value cannot be empty. Try again");
                    continue;
                }
                return name;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public String receiveZipCode() {
        for ( ; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a zip-code. Max length is 30: ");
                String code = scanner.nextLine().trim();
                if (code.equals("")) {
                    System.out.println("This value cannot be empty. Try again");
                    continue;
                }
                if (code.length() > 30) {
                    System.out.println("Max string length is 30. Try again.");
                    continue;
                }
                return code;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public double receiveXLocation() {
        for ( ; ; ) {
            try {
                System.out.print("Enter X coordinate of location: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextDouble();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a double-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public Long receiveYLocation() {
        for ( ; ; ) {
            try {
                System.out.print("Enter Y coordinate of location: ");
                Scanner scanner = new Scanner(System.in);
                Long y = scanner.nextLong();
                if (String.valueOf(y).equals("")) {
                    System.out.println("Value must not be empty. Try again.");
                    continue;
                }
                return y;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public long receiveZLocation() {
        for ( ; ; ) {
            try {
                System.out.print("Enter Z coordinate of location: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextLong();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a long-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(1);
            }
        }
    }

    public Location receiveLocation() {
        return new Location(receiveXLocation(), receiveYLocation(), receiveZLocation());
    }

    public Address receiveAddress() {
        return new Address(receiveStreet(), receiveZipCode(), receiveLocation());
    }

    public Organization receiveOrganization() {
        return new Organization(receiveId(), receiveName(), receiveCoordinates(), receiveDate(),
                receiveAnnualTurnover(), receiveFullName(), receiveEmployeesCount(),
                receiveOrganizationType(), receiveAddress(), collectionManipulator.getCurrentUser());
    }

}
