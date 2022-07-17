package commands;

import collectionUsage.CollectionManipulator;
import data.Organization;
import javafx.collections.ObservableList;

import java.util.Stack;

public class FilterByEmployeesCountCommand extends AbstractCommand {

    public FilterByEmployeesCountCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute(String arg) {
        try {
            ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
            Long current = Long.valueOf(arg);
            StringBuilder stringBuilder = new StringBuilder();
            for (Organization organization : organizations) {
                if (organization.getEmployeesCount() == current) {
                    stringBuilder.append(organization.toString()).append("\n");
                }
            }
            return "Items which employeesCount field is equal for a given:\n" + stringBuilder;
        } catch (Exception e) {
            System.out.println("Command executing error.");
            return "No such items";
        }
    }

}

