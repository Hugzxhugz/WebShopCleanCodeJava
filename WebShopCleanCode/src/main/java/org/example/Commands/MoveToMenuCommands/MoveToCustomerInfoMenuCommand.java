package org.example.Commands.MoveToMenuCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.CustomerInfoState;


public class MoveToCustomerInfoMenuCommand implements ICommand {

    @Override
    public void Execute() {
        IMenuState customerInfoMenu = new CustomerInfoState();
        customerInfoMenu.DisplayMenu();
    }
}
