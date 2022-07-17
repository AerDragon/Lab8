package commands;

import collectionUsage.CollectionManipulator;

public class HelpCommand extends AbstractCommand {

    public HelpCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute() {
        return collectionManipulator.help();
    }
}
