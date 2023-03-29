package org.example.MenuState.CustomerInfoOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.MoveToMenuCommands.MoveToCustomerInfoMenuCommand;
import org.example.MenuContextAndProxy;

public class SeeInfoState extends MenuStateFactory {

    public SeeInfoState(){
        this.currentMenu = "Set Info Menu";
    }


    public void DisplayMenu() {
        MenuContextAndProxy.GetInstance().GetLoggedInCustomer().PrintInfo();
        new MoveToCustomerInfoMenuCommand().Execute();
    }
}
