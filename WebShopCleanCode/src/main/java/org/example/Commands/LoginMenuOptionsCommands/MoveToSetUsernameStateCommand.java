package org.example.Commands.LoginMenuOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.LogInOptions.SetUsernameState;

public class MoveToSetUsernameStateCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState setUsername = new SetUsernameState();
        setUsername.DisplayMenu();
    }
}
