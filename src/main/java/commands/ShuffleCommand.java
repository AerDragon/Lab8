package commands;

import collectionUsage.CollectionManipulator;
import data.Organization;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Stack;

public class ShuffleCommand extends AbstractCommand {

    public ShuffleCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute() {
        ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
        Collections.shuffle(organizations);
        return "Collection has been shuffled successfully!";
    }

}