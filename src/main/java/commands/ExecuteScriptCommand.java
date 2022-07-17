package commands;

import collectionUsage.CollectionManipulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteScriptCommand extends AbstractCommand {

    public ExecuteScriptCommand(CollectionManipulator collectionManipulator) {
        super(collectionManipulator);
    }

    public String execute(String nameOfFile) {
        try {
            if (collectionManipulator.getCurrentUser() == null) {
                return "You need to login before using this command.";
            }
            System.out.println("WARNING. To avoid recursion, your file cannot contain execute script commands.");
            BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
            StringBuilder message = new StringBuilder();
            String[] finalUserCommand;
            String command;
            while((command = reader.readLine()) != null) {
                finalUserCommand = command.trim().toLowerCase().split(" ", 2);
                switch (finalUserCommand[0]) {
                    case "help":
                        HelpCommand help = new HelpCommand(collectionManipulator);
                        message.append(help.execute()).append("\n");
                        break;
                    case "info":
                        InfoCommand info = new InfoCommand(collectionManipulator);
                        message.append(info.execute()).append("\n");
                        break;
                    case "show":
                        ShowCommand show = new ShowCommand(collectionManipulator);
                        message.append(show.execute()).append("\n");
                        break;
                    case "add":
                        AddCommand add = new AddCommand(collectionManipulator);
                        message.append(add.execute()).append("\n");
                        break;
                    case "update":
                        UpdateCommand update = new UpdateCommand(collectionManipulator);
                        message.append(update.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "remove_by_id":
                        RemoveByIdCommand remove = new RemoveByIdCommand(collectionManipulator);
                        message.append(remove.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "clear":
                        ClearCommand clear = new ClearCommand(collectionManipulator);
                        message.append(clear.execute()).append("\n");
                        break;
                    case "save":
                        SaveCommand save = new SaveCommand(collectionManipulator);
                        message.append(save.execute()).append("\n");
                        break;
                    case "execute_script":
                        message.append("This script cannot to contain this command.").append("\n");
                        break;
                    case "exit":
                        message.append("Exit command is denied for security reasons.").append("\n");
                        break;
                    case "remove_first":
                        RemoveFirstCommand removeHeadCommand = new RemoveFirstCommand(collectionManipulator);
                        message.append(removeHeadCommand.execute()).append("\n");
                        break;
                    case "history":
                        message.append("This command denied here.");
                        break;
                    case "count_less_than_postal_address":
                        CountLessThanPostalAddressCommand countLessThanPostalAddressCommand =
                                new CountLessThanPostalAddressCommand(collectionManipulator);
                        message.append(countLessThanPostalAddressCommand.execute(finalUserCommand[1]));
                        break;
                    case "filter_by_employees_count:":
                        FilterByEmployeesCountCommand filterByEmployeesCountCommand =
                                new FilterByEmployeesCountCommand(collectionManipulator);
                        message.append(filterByEmployeesCountCommand.execute(finalUserCommand[1]));
                        break;
                    case "shuffle":
                        ShuffleCommand shuffleCommand = new ShuffleCommand(collectionManipulator);
                        message.append(shuffleCommand.execute());
                        break;
                    case "sum_of_annual_turnover":
                        SumOfAnnualTurnoverCommand sumOfAnnualTurnoverCommand =
                                new SumOfAnnualTurnoverCommand(collectionManipulator);
                        message.append(sumOfAnnualTurnoverCommand.execute());
                        break;
                    default:
                        message.append("Unknown command").append("\n");
                        break;
                }
            }
            reader.close();
            return message.toString();
        } catch (FileNotFoundException fileNotFoundException) {
            return "File not found. Try again.";
        } catch (IOException ioException) {
            return "File reading exception. Try again.";
        }
    }

}
