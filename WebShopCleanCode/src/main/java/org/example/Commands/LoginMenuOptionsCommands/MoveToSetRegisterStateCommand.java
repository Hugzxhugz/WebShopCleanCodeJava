package org.example.Commands.LoginMenuOptionsCommands;

import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuState.LogInOptions.SetRegisterState;

public class MoveToSetRegisterStateCommand implements ICommand {


    @Override
    public void Execute() {
        IMenuState setRegister = new SetRegisterState();
        setRegister.DisplayMenu();
    }
}
