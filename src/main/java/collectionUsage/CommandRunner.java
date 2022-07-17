package collectionUsage;

import commands.*;

import java.util.Scanner;

public class CommandRunner {

    public void run(CollectionManipulator collectionManager) {
        try {
            String[] finalUserCommand;
//            while (true) {
//                System.out.print("Enter a command: ");
//                Scanner scanner = new Scanner(System.in);
//                finalUserCommand = scanner.nextLine().trim().toLowerCase().split(" ", 2);
//                switch (finalUserCommand[0]) {
//                    case "register":
//                        collectionManager.register();
//                        break;
//                    case "login":
//                        Scanner scannerr = new Scanner(System.in);
//                        System.out.print("Enter your login: ");
//                        String login = scannerr.nextLine().trim();
//                        if (login.equals("")) {
//                            System.out.println("Login cannot be empty. Try again");
//                            continue;
//                        }
//                        System.out.print("Enter your password: ");
//                        String password = scannerr.nextLine();
//                        if (password.equals("")) {
//                            System.out.println("Password cannot be empty. Try again");
//                            continue;
//                        }
//                        collectionManager.login(login, password);
//                        break;
//                    case "logout":
//                        collectionManager.logout();
//                        break;
//                    case "help":
//                        HelpCommand help = new HelpCommand(collectionManager);
//                        System.out.println(help.execute());
//                        break;
//                    case "info":
//                        InfoCommand info = new InfoCommand(collectionManager);
//                        System.out.println(info.execute());
//                        break;
//                    case "show":
//                        ShowCommand show = new ShowCommand(collectionManager);
//                        System.out.println(show.execute());
//                        break;
//                    case "add":
//                        AddCommand add = new AddCommand(collectionManager);
//                        System.out.println(add.execute());
//                        break;
//                    case "update":
//                        UpdateCommand update = new UpdateCommand(collectionManager);
//                        if (finalUserCommand.length == 1) {
//                            System.out.println("You forgot type argument to this command. Try again.");
//                            break;
//                        }
//                        System.out.println(update.execute(finalUserCommand[1]));
//                        break;
//                    case "remove_by_id":
//                        RemoveByIdCommand remove = new RemoveByIdCommand(collectionManager);
//                        if (finalUserCommand.length == 1) {
//                            System.out.println("You forgot type argument to this command. Try again.");
//                            break;
//                        }
//                        System.out.println(remove.execute(finalUserCommand[1]));
//                        break;
//                    case "clear":
//                        ClearCommand clear = new ClearCommand(collectionManager);
//                        System.out.println(clear.execute());
//                        break;
//                    case "save":
//                        SaveCommand save = new SaveCommand(collectionManager);
//                        System.out.println(save.execute());
//                        break;
//                    case "execute_script":
//                        ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand(collectionManager);
//                        if (finalUserCommand.length == 1) {
//                            System.out.println("You forgot type argument to this command. Try again.");
//                            break;
//                        }
//                        System.out.println(executeScriptCommand.execute(finalUserCommand[1]));
//                        break;
//                    case "exit":
//                        System.out.println("Program will be finished now");
//                        new ExitCommand(collectionManager).execute();
//                        break;
//                    case "count_less_than_postal_address":
//                        CountLessThanPostalAddressCommand countLessThanPostalAddressCommand =
//                                new CountLessThanPostalAddressCommand(collectionManager);
//                        if (finalUserCommand.length == 1) {
//                            System.out.println("You forgot type argument to this command. Try again.");
//                            break;
//                        }
//                        System.out.println(countLessThanPostalAddressCommand.execute(finalUserCommand[1]));
//                        break;
//                    case "filter_by_employees_count:":
//                        FilterByEmployeesCountCommand filterByEmployeesCountCommand =
//                                new FilterByEmployeesCountCommand(collectionManager);
//                        if (finalUserCommand.length == 1) {
//                            System.out.println("You forgot type argument to this command. Try again.");
//                            break;
//                        }
//                        System.out.println(filterByEmployeesCountCommand.execute(finalUserCommand[1]));
//                        break;
//                    case "shuffle":
//                        ShuffleCommand shuffleCommand = new ShuffleCommand(collectionManager);
//                        System.out.println(shuffleCommand.execute());
//                        break;
//                    case "sum_of_annual_turnover":
//                        SumOfAnnualTurnoverCommand sumOfAnnualTurnoverCommand =
//                                new SumOfAnnualTurnoverCommand(collectionManager);
//                        System.out.println(sumOfAnnualTurnoverCommand.execute());
//                        break;
//                    case "remove_first":
//                        RemoveFirstCommand removeFirstCommand = new RemoveFirstCommand(collectionManager);
//                        System.out.println(removeFirstCommand.execute());
//                        break;
//                    default:
//                        System.out.println("Unknown command");
//                        break;
//                }
//            }
        } catch (Exception e) {
            System.out.println("Incorrect argument. Try again.");
            e.printStackTrace();
        }
    }

}
