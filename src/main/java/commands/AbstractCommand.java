package commands;

import collectionUsage.CollectionManipulator;

public abstract class AbstractCommand {

    protected final CollectionManipulator collectionManipulator;

    public AbstractCommand(CollectionManipulator collectionManipulator) {
        this.collectionManipulator = collectionManipulator;
    }

}
