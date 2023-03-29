package org.example.MenuState.CustomerInfoOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.MoveToMenuCommands.MoveToCustomerInfoMenuCommand;
import org.example.MenuContextAndProxy;

public class SeeOrdersState extends MenuStateFactory {

    public SeeOrdersState(){
        this.currentMenu = "See Orders Menu";
    }

    public void DisplayMenu() {
        MenuContextAndProxy.GetInstance().GetLoggedInCustomer().PrintOrders();
        new MoveToCustomerInfoMenuCommand().Execute();
    }
}
