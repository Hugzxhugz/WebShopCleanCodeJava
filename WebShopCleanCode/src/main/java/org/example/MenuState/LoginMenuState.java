package org.example.MenuState;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.LoginMenuOptionsCommands.MoveToSetLoginStateCommand;
import org.example.Commands.LoginMenuOptionsCommands.MoveToSetPasswordStateCommand;
import org.example.Commands.LoginMenuOptionsCommands.MoveToSetRegisterStateCommand;
import org.example.Commands.LoginMenuOptionsCommands.MoveToSetUsernameStateCommand;
import org.example.Interface.ICommand;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginMenuState extends MenuStateFactory {

    HashMap<String, ICommand> commands;
    String quitCommand;
    public LoginMenuState(){
        this.currentMenu = "Login Menu";
        this.currentChoice = 1;
        this.commands = new HashMap<>();
        this.optionsList = new ArrayList<>();
        optionsList.add("1: Set Username");
        optionsList.add("2: Set Password");
        optionsList.add("3: Login");
        optionsList.add("4: Register");
        amountOfOptions = optionsList.size();
        this.quitCommand = "QuitIsEntered";
        commands.put("1", new MoveToSetUsernameStateCommand());
        commands.put("2", new MoveToSetPasswordStateCommand());
        commands.put("3", new MoveToSetLoginStateCommand());
        commands.put("4", new MoveToSetRegisterStateCommand());

    }

    public void DisplayMenu() {
        String input = "";
        while (!input.equals(quitCommand)) {
            System.out.println("Please submit username and password.");
            System.out.println(currentMenu + ":");
            PrintOptions();
            GetUserChoice();
            DisplayMenu();
            ExecuteCommandIfExists(currentChoice);

        }
    }

    public void PrintOptions() {
        for (String option: optionsList) {
            System.out.println(option);
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

}
