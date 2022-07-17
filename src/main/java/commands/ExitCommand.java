package commands;

import collectionUsage.CollectionManipulator;

public class ExitCommand extends AbstractCommand {

    public ExitCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public void execute() {
        collectionManipulator.exit();
    }

}