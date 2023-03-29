package org.example.MenuState.WaresOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Abstract.ProductFactory;
import org.example.Commands.MoveToMenuCommands.MoveToWaresMenuCommand;
import org.example.Interface.ICommand;
import org.example.MenuContextAndProxy;
import org.example.ProductsList;

import java.util.ArrayList;

public class ProductListMenu extends MenuStateFactory {

    private ProductsList products = new ProductsList();
    private ArrayList <ProductFactory> productsList;
    private ICommand command;

    public ProductListMenu() {
        if (MenuContextAndProxy.GetInstance().GetSortedProductsList().isEmpty())
            this.productsList = products.GetProductsList();
        else{
            this.productsList = MenuContextAndProxy.GetInstance().GetSortedProductsList();
        }
        this.currentMenu = "Product list Menu";
    }

    public void DisplayMenu() {
        if (MenuContextAndProxy.GetInstance().GetSortedProductsList().isEmpty())
            products.PrintProductList();
        else{
            MenuContextAndProxy.GetInstance().PrintSortedProductList();
        }
        command = new MoveToWaresMenuCommand();
        command.Execute();
    }
}
