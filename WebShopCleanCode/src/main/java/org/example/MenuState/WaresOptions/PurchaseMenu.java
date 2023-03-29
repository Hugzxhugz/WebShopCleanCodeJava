package org.example.MenuState.WaresOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Abstract.ProductFactory;
import org.example.Commands.MoveToWaresOptionsCommands.PurchaseProductCommand;
import org.example.Interface.ICommand;
import org.example.MenuContextAndProxy;
import org.example.ProductsList;

import java.util.ArrayList;
import java.util.HashMap;

public class PurchaseMenu extends MenuStateFactory {

    private ProductsList products = new ProductsList();
    HashMap<String, ICommand> commands;
    private ArrayList<ProductFactory> productsList;
    private String quitCommand;

    public PurchaseMenu() {

        if (MenuContextAndProxy.GetInstance().GetSortedProductsList().isEmpty())
            this.productsList = products.GetProductsList();
        else{
            this.productsList = MenuContextAndProxy.GetInstance().GetSortedProductsList();
        }
        this.currentMenu = "Purchase Menu";
        this.currentChoice = 1;
        this.commands = new HashMap<>();
        this.quitCommand = "QuitIsEntered";
        this.info = "What would you like to purchase.";
        this.optionsList = new ArrayList<>();
        for (int i = 0; i < productsList.size(); i++) {
            ProductFactory product = productsList.get(i);
            optionsList.add((i + 1) + ": " + product.GetName() + ", " + product.GetPrice() + "kr");
            commands.put(String.valueOf(i + 1), new PurchaseProductCommand(product));
        }
        this.amountOfOptions = optionsList.size();
    }

    @Override
    public void DisplayMenu() {

        String input = "";
        while (!input.equals(quitCommand)) {
            System.out.println(info);
            System.out.println(currentMenu + ":");
            PrintOptions();
            if(MenuContextAndProxy.GetInstance().GetLoggedInCustomer() != null){
                DisplayFunds();
            }
            GetUserChoice();
            DisplayMenu();

            ExecuteCommandIfExists(currentChoice);

        }
    }

    private void DisplayFunds() {
        System.out.println("Your funds: " + MenuContextAndProxy.GetInstance().GetLoggedInCustomer().GetFunds());
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
