package org.example.Commands.MoveToMenuCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.WaresMenuState;

public class MoveToWaresMenuCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState waresMenu = new WaresMenuState();
        waresMenu.DisplayMenu();
    }
}
