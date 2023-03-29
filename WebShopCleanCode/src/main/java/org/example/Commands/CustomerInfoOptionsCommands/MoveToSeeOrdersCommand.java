package org.example.Commands.CustomerInfoOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.CustomerInfoOptions.SeeOrdersState;

public class MoveToSeeOrdersCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState seeOrders = new SeeOrdersState();
        seeOrders.DisplayMenu();
    }
}
