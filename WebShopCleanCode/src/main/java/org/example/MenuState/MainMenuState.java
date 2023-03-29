package org.example.MenuState;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.CustomerInfoOptionsCommands.IfNoUserIsLoggedInCommand;
import org.example.Commands.LogoutCommand;
import org.example.Commands.MoveToMenuCommands.MoveToCustomerInfoMenuCommand;
import org.example.Commands.MoveToMenuCommands.MoveToLoginMenuCommand;
import org.example.Commands.MoveToMenuCommands.MoveToWaresMenuCommand;
import org.example.Interface.ICommand;
import org.example.MenuContextAndProxy;

import java.util.*;

public class MainMenuState extends MenuStateFactory {

    HashMap<String, ICommand> commands;
    String quitCommand;


    public MainMenuState()
    {

        this.currentMenu = "Main Menu";
        this.currentChoice = 1;
        this.commands = new HashMap<>();
        this.optionsList = new ArrayList<>();
        this.quitCommand = "quit";

        if (MenuContextAndProxy.GetInstance().GetLoggedInCustomer() != null) {
            optionsList.add("1: See wares");
            optionsList.add("2: Customer info");
            optionsList.add("3: Logout");
            amountOfOptions = optionsList.size();
            commands.put("1", new MoveToWaresMenuCommand());
            commands.put("2", new MoveToCustomerInfoMenuCommand());
            commands.put("3", new LogoutCommand());
        } else {
            optionsList.add("1: See wares");
            optionsList.add("2: Customer info");
            optionsList.add("3: Login");
            amountOfOptions = optionsList.size();
            commands.put("1", new MoveToWaresMenuCommand());
            if (MenuContextAndProxy.GetInstance().GetLoggedInCustomer() != null){
                commands.put("2", new MoveToCustomerInfoMenuCommand());
            }
            else{
                commands.put("2", new IfNoUserIsLoggedInCommand());
            }
            commands.put("3", new MoveToLoginMenuCommand());;
        }
    }

    public void DisplayMenu() {

        String input = "";
        while (!input.equals(quitCommand)) {
            System.out.println("What would you like to do?");
            System.out.println(currentMenu + ":");
            PrintOptions();
            GetUserChoice();
            DisplayMenu();
            ExecuteCommandIfExists(currentChoice);

        }
    }

    public int ExecuteCommandIfExists(int currentChoice)
    {
        String input = Integer.toString(currentChoice);
        ICommand command = commands.get(input);
        if (command != null) {
            command.Execute();
        } else {
            System.out.println("That is not an applicable option.");
        }
        return currentChoice;
    }

    public void PrintOptions() {
        for (String option: optionsList) {
            System.out.println(option);
        }
    }

}
