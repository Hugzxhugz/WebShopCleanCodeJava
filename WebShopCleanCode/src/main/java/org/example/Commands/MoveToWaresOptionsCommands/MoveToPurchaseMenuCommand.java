package org.example.Commands.MoveToWaresOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuContextAndProxy;
import org.example.MenuState.WaresMenuState;
import org.example.MenuState.WaresOptions.PurchaseMenu;

public class MoveToPurchaseMenuCommand implements ICommand {


    @Override
    public void Execute() {

        String message = "\nYou must be logged in to purchase wares.\n";

        if(MenuContextAndProxy.GetInstance().GetLoggedInCustomer() != null) {
            IMenuState purchaseMenu = new PurchaseMenu();
            purchaseMenu.DisplayMenu();
        }
        else{
            System.out.println(message);
            IMenuState waresMenu = new WaresMenuState();
            waresMenu.DisplayMenu();
        }
    }


}
