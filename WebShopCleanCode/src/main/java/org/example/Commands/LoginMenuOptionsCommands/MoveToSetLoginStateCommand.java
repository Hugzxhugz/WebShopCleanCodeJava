package org.example.Commands.LoginMenuOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.LogInOptions.SetLoginState;

public class MoveToSetLoginStateCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState setLogin = new SetLoginState();
        setLogin.DisplayMenu();
    }
}