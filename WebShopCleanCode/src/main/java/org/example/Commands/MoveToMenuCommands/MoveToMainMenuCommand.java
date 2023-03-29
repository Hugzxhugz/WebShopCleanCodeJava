package org.example.Commands.MoveToMenuCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.MainMenuState;

public class MoveToMainMenuCommand implements ICommand {

    @Override
    public void Execute() {
        IMenuState mainMenu = new MainMenuState();
        mainMenu.DisplayMenu();
    }

}
