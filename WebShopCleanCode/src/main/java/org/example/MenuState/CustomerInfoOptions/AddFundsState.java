package org.example.MenuState.CustomerInfoOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.MoveToMenuCommands.MoveToCustomerInfoMenuCommand;
import org.example.Builder.CustomerBuilder;

public class AddFundsState extends MenuStateFactory {

    int funds;
    CustomerBuilder builder = new CustomerBuilder();
    public AddFundsState(){
        this.currentMenu = "Add Funds Menu";
    }


    public void DisplayMenu() {
        funds = builder.SetFunds();
        new MoveToCustomerInfoMenuCommand().Execute();

    }
}
