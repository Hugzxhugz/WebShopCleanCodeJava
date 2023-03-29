package org.example.MenuState.WaresOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Abstract.ProductFactory;
import org.example.Commands.SortingCommands.SortByNameAscendingCommand;
import org.example.Commands.SortingCommands.SortByNameDescendingCommand;
import org.example.Commands.SortingCommands.SortByPriceAscendingCommand;
import org.example.Commands.SortingCommands.SortByPriceDescendingCommand;
import org.example.Interface.ICommand;
import org.example.ProductsList;

import java.util.ArrayList;
import java.util.HashMap;

public class SortWaresMenu extends MenuStateFactory {

    private ArrayList<ProductFactory> productsList;
    private ProductsList products = new ProductsList();
    private String quitCommand;
    private HashMap<String, ICommand> commands;

    public SortWaresMenu() {
        this.currentMenu = "Sort Wares Menu";
        this.currentChoice = 1;
        this.commands = new HashMap<>();
        this.optionsList = new ArrayList<>();
        this.info = "How would you like to sort them?";
        optionsList.add("1: Sort by name, descending");
        optionsList.add("2: Sort by name, ascending");
        optionsList.add("3: Sort by price, descending");
        optionsList.add("4: Sort by price, ascending");
        amountOfOptions = optionsList.size();
        this.quitCommand = "QuitIsEntered";
        commands.put("1", new SortByNameDescendingCommand());
        commands.put("2", new SortByNameAscendingCommand());
        commands.put("3", new SortByPriceDescendingCommand());
        commands.put("4", new SortByPriceAscendingCommand());

    }

    @Override
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
