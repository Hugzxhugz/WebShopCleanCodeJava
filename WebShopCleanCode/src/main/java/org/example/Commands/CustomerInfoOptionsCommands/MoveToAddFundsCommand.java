package org.example.Commands.CustomerInfoOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.CustomerInfoOptions.AddFundsState;

public class MoveToAddFundsCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState addFunds = new AddFundsState();
        addFunds.DisplayMenu();
    }
}
