package org.example.Commands.CustomerInfoOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.CustomerInfoOptions.SeeInfoState;

public class MoveToSeeYourInfoCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState seeInfo = new SeeInfoState();
        seeInfo.DisplayMenu();
    }
}
