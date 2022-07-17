package commands;

import collectionUsage.CollectionManipulator;
import data.Organization;
import javafx.collections.ObservableList;

import java.util.Stack;

public class ShowCommand extends AbstractCommand {

    public ShowCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();
        ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
        for (Organization organization : organizations) {
            stringBuilder.append(organization.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}

