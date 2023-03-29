package org.example.Commands.SortingCommands;

import org.example.Abstract.ProductFactory;
import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuContextAndProxy;
import org.example.MenuState.WaresMenuState;
import org.example.ProductsList;
import org.example.Sorting;

import java.util.ArrayList;

public class SortByPriceDescendingCommand implements ICommand {
    @Override
    public void Execute() {
        ProductsList products = new ProductsList();
        Sorting sort = new Sorting();
        String message = "\nWares sorted.\n";
        ArrayList<ProductFactory> productslist = products.GetProductsList();
        ArrayList<ProductFactory> sortedList = sort.SortProductsByPriceDescending(productslist);
        MenuContextAndProxy.GetInstance().SetProductsToSortedList(sortedList);

        System.out.println(message);
        IMenuState waresMenu = new WaresMenuState();
        waresMenu.DisplayMenu();
    }
}
