package collectionUsage;

public class Client {

    public static void start() {
        System.out.println("8th lab work system had started!");
        CommandRunner commandRunner = new CommandRunner();
        CollectionManipulator collectionManipulator = new CollectionManipulator();
        commandRunner.run(collectionManipulator);
    }

}
