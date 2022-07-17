package commands;

import collectionUsage.CollectionManipulator;
import data.Organization;
import javafx.collections.ObservableList;

import java.util.Stack;

public class CountLessThanPostalAddressCommand extends AbstractCommand {

    public CountLessThanPostalAddressCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute(String argument) {
        try {
            if (argument != null) {
                ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
                int counter = 0;
                for (Organization organization : organizations) {
                    if (organization.getPostalAddress().getStreet().length() < argument.length()) {
                        counter += 1;
                    }
                }
                return counter + " field type values in your collection are greater than given.";
            } else return "Incorrect argument.";
        } catch (Exception e) {
            System.out.println("Command executing error");
            return "There are no such items";
        }
    }

}
