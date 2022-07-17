package commands;

import collectionUsage.CollectionManipulator;

public class SaveCommand extends AbstractCommand {

    public SaveCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute() {
        return collectionManipulator.save();
    }

}