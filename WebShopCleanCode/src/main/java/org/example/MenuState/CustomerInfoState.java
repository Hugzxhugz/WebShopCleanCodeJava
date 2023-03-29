package org.example.MenuState;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.CustomerInfoOptionsCommands.MoveToAddFundsCommand;
import org.example.Commands.CustomerInfoOptionsCommands.MoveToSeeOrdersCommand;
import org.example.Commands.CustomerInfoOptionsCommands.MoveToSeeYourInfoCommand;
import org.example.Interface.ICommand;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerInfoState extends MenuStateFactory {

    HashMap<String, ICommand> commands;
    String quitCommand;
    public CustomerInfoState()
    {
        this.currentMenu = "Customer Info Menu";
        this.currentChoice = 1;
        this.commands = new HashMap<>();
        this.optionsList = new ArrayList<>();
        optionsList.add("1: See your orders");
        optionsList.add("2: Set your info");
        optionsList.add("3: Add funds");
        amountOfOptions = optionsList.size();
        this.quitCommand = "QuitIsEntered";
        commands.put("1", new MoveToSeeOrdersCommand());
        commands.put("2", new MoveToSeeYourInfoCommand());
        commands.put("3", new MoveToAddFundsCommand());
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
    @Override
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
