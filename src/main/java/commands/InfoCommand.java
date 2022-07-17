package commands;

import collectionUsage.CollectionManipulator;

public class InfoCommand extends AbstractCommand {

    public InfoCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute() {
        return "Type of collection: " + collectionManipulator.getOrganizations().getClass() + "\n" +
                "Initialization date: " + collectionManipulator.getInitializationDate() + "\n" +
                "Amount of elements: " + collectionManipulator.getOrganizations().size() + "\n";
    }

}