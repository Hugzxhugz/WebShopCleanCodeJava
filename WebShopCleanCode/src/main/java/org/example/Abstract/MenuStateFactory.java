package org.example.Abstract;

import org.example.Commands.MoveToMenuCommands.MoveToMainMenuCommand;
import org.example.Commands.MoveToMenuCommands.MoveToWaresMenuCommand;
import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuContextAndProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class MenuStateFactory implements IMenuState {

    protected String currentMenu;
    protected int currentChoice;
    protected HashMap<String, Runnable> commands;
    protected int amountOfOptions;
    protected ArrayList<String> optionsList;
    protected String info;
    protected Scanner scanner;

    public MenuStateFactory() {
        scanner = new Scanner(System.in);
    }


    @Override
    public void DisplayMenu() {
    }

    public int ExecuteCommandIfExists(int currentChoice) {
        String input = Integer.toString(currentChoice);
        Runnable command = commands.get(input);
        if (command != null) {
            command.run();
        } else {
            System.out.println("That is not an applicable option.");
        }
        return currentChoice;
    }

    public void PrintOptions() {
        for (String option: optionsList) {
            System.out.println(option);
        }
        System.out.println(info);
    }

    protected void GetUserChoice(){
        commands = new HashMap<>();
        commands.put("left", this::MoveLeft);
        commands.put("l", this::MoveLeft);
        commands.put("right", this::MoveRight);
        commands.put("r", this::MoveRight);
        commands.put("back", this::Back);
        commands.put("b", this::Back);
        commands.put("ok", this::OkIsEntered);
        commands.put("k", this::OkIsEntered);
        commands.put("o", this::OkIsEntered);
        commands.put("quit", this::QuitIsEntered);
        commands.put("q", this::QuitIsEntered);

        setCursor(amountOfOptions,currentChoice);
        System.out.println("Your buttons are Left, Right, OK, Back and Quit.");
        if (MenuContextAndProxy.GetInstance().GetLoggedInCustomer() != null) {
            System.out.println("Current user: " + MenuContextAndProxy.GetInstance().GetLoggedInCustomer().GetUsername());
        } else {
            System.out.println("Nobody logged in.");
        }

        String selection = scanner.nextLine().toLowerCase();
        Runnable command = commands.get(selection);
        if (command != null) {
            command.run();
        } else {
            System.out.println("That is not an applicable option.");
        }
    }

    public void setCursor(int amountOfOptions, int currentChoice) {
        for (int i = 0; i < amountOfOptions; i++) {
            System.out.print(i + 1 + "\t");
        }
        System.out.println();
        for (int i = 1; i < currentChoice; i++) {
            System.out.print("\t");
        }
        System.out.println("|");
    }

    public void MoveLeft(){
        if (currentChoice > 1) {
            currentChoice--;
        }
    }

    public void MoveRight(){
        if (currentChoice < amountOfOptions) {
            currentChoice++;
        }
    }

    public void Back(){
        ICommand command;
        if (currentMenu.equals("Main Menu")) {
            System.out.println("\nYou're already on the main menu.\n");
            command = new MoveToMainMenuCommand();
            command.Execute();
        } else if (currentMenu.equals("Purchase Menu")) {
            command = new MoveToWaresMenuCommand();
            command.Execute();
        } else {
            command = new MoveToMainMenuCommand();
            command.Execute();
        }
    }

    public void OkIsEntered(){
        ExecuteCommandIfExists(currentChoice);
    }

    public void QuitIsEntered(){
        System.out.println("The console powers down. You are free to leave.");
        System.exit(0);
    }


}
