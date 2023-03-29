package org.example.Commands.MoveToWaresOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.WaresOptions.SortWaresMenu;

public class MoveToSortWaresMenuCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState sortWaresMenu = new SortWaresMenu();
        sortWaresMenu.DisplayMenu();
    }
}
