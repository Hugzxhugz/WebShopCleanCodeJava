package org.example.Commands.LoginMenuOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.LogInOptions.SetPasswordState;

public class MoveToSetPasswordStateCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState setPassword = new SetPasswordState();
        setPassword.DisplayMenu();
    }
}
