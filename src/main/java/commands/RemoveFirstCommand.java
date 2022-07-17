package commands;

import collectionUsage.CollectionManipulator;
import data.Organization;
import javafx.collections.ObservableList;

import java.util.Stack;

public class RemoveFirstCommand extends AbstractCommand {

    public RemoveFirstCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute() {
        if (collectionManipulator.getCurrentUser() == null) {
            return "You need to login before using this command.";
        }
        ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
        organizations.removeIf(e -> (e.getOwner().equals(collectionManipulator.getCurrentUser()) && e.getId() == 1));
        return "Command executed. Print show for checking result.";
    }
}
