package org.example.MenuState;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.MoveToMenuCommands.MoveToLoginMenuCommand;
import org.example.Commands.MoveToWaresOptionsCommands.MoveToProductListMenuCommand;
import org.example.Commands.MoveToWaresOptionsCommands.MoveToPurchaseMenuCommand;
import org.example.Commands.MoveToWaresOptionsCommands.MoveToSortWaresMenuCommand;
import org.example.Commands.MoveToWaresOptionsCommands.WaresMenuLogOutCommand;
import org.example.Interface.ICommand;
import org.example.MenuContextAndProxy;

import java.util.ArrayList;
import java.util.HashMap;

public class WaresMenuState extends MenuStateFactory {

    HashMap<String, ICommand> commands;
    String quitCommand;
    public WaresMenuState(){
        this.currentMenu = "Wares Menu";
        this.currentChoice = 1;
        this.commands = new HashMap<>();
        this.optionsList = new ArrayList<>();
        this.info = "What would you like to do?";
        this.quitCommand = "QuitIsEntered";

        if (MenuContextAndProxy.GetInstance().GetLoggedInCustomer() != null) {
            optionsList.add("1: See all wares");
            optionsList.add("2: Purchase a ware");
            optionsList.add("3: Sort wares");
            optionsList.add("4: Logout");
            amountOfOptions = optionsList.size();
            commands.put("1", new MoveToProductListMenuCommand());
            commands.put("2", new MoveToPurchaseMenuCommand());
            commands.put("3", new MoveToSortWaresMenuCommand());
            commands.put("4", new WaresMenuLogOutCommand());
        } else {
            optionsList.add("1: See all wares");
            optionsList.add("2: Purchase a ware");
            optionsList.add("3: Sort wares");
            optionsList.add("4: Login");
            amountOfOptions = optionsList.size();
            commands.put("1", new MoveToProductListMenuCommand());
            commands.put("2", new MoveToPurchaseMenuCommand());
            commands.put("3", new MoveToSortWaresMenuCommand());
            commands.put("4", new MoveToLoginMenuCommand());
        }

    }

    public void DisplayMenu() {

        String input = "";
        while (!input.equals(quitCommand)) {
            System.out.println(info);
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
