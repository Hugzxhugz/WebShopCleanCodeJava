package org.example.Commands.MoveToWaresOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.WaresOptions.ProductListMenu;

public class MoveToProductListMenuCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState productListMenu = new ProductListMenu();
        productListMenu.DisplayMenu();
    }
}
