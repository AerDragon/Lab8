package commands;

import collectionUsage.CollectionManipulator;
import data.Organization;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Stack;

public class RemoveByIdCommand extends AbstractCommand {

    public RemoveByIdCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public synchronized String execute(String id) {
        ObservableList<Organization> organizations = collectionManipulator.getOrganizations();
        if (collectionManipulator.getCurrentUser() == null) {
            return "You need to login before using this command.";
        }
        int index = -1;
        boolean exists = false;
        String user = null;
        for (Organization organization : organizations) {
            Long longId = organization.getId();
            String strId = String.valueOf(longId);
            if (strId.equals(id)) {
                exists = true;
                index = organizations.indexOf(organization);
                user = organization.getOwner();
            }
        }
        if (exists && collectionManipulator.getCurrentUser().equals(user)) {
            String delete = "DELETE FROM organizations WHERE id = ?";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = collectionManipulator.getConnection().prepareStatement(delete);
                preparedStatement.setLong(1, organizations.get(index).getId());
                preparedStatement.executeUpdate();
                organizations.remove(index);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return "Command executed. Type show command for checking result.";
    }

}
