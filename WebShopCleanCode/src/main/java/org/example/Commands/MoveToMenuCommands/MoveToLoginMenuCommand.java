package org.example.Commands.MoveToMenuCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.LoginMenuState;

public class MoveToLoginMenuCommand implements ICommand {

    @Override
    public void Execute() {
        IMenuState loginMenu = new LoginMenuState();
        loginMenu.DisplayMenu();
    }
}
