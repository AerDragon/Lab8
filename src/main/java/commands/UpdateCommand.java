package commands;

import collectionUsage.CollectionManipulator;
import collectionUsage.ValueReceiver;
import controllers.OrganizationProp;
import data.Organization;
import javafx.collections.ObservableList;

import java.util.Stack;

public class UpdateCommand extends AbstractCommand {

    public UpdateCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public synchronized String execute(String id) {
        try {
            ValueReceiver receiver = new ValueReceiver(collectionManipulator);
            if (collectionManipulator.getCurrentUser() == null) {
                return "You need to login before using this command.";
            }
            ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
            for (Organization organization : organizations) {
                Long longId = organization.getId();
                String strId = String.valueOf(longId);
                if (strId.equals(id) && collectionManipulator.getCurrentUser().equals(organization.getOwner())) {
                    organizations.remove(organization);
                    Organization organization1 = new ValueReceiver(collectionManipulator).receiveOrganization();
                    organization1.setId(new Long(id));
                    organizations.add(organization1);
                }
            }
            return "Command executed. Type show command for checking result.";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Collection updating error.";
        }
    }

}