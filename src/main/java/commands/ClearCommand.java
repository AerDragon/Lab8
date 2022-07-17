package commands;

import collectionUsage.CollectionManipulator;
import data.Organization;
import javafx.collections.ObservableList;

import java.util.Stack;

public class ClearCommand extends AbstractCommand {

    public ClearCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute() {
        if (collectionManipulator.getCurrentUser() == null) {
            return "You need to login before using this command.";
        }
        ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
        organizations.removeIf(e -> e.getOwner().equals(collectionManipulator.getCurrentUser()));
        return "Your items removed successfully. Another items are not removed.";
    }

}