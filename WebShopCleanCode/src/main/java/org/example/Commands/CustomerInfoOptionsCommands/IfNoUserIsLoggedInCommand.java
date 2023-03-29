package org.example.Commands.CustomerInfoOptionsCommands;

import org.example.Commands.MoveToMenuCommands.MoveToMainMenuCommand;
import org.example.Interface.ICommand;

public class IfNoUserIsLoggedInCommand implements ICommand {
    @Override
    public void Execute() {
        System.out.println("\nNobody is logged in.\n");
        new MoveToMainMenuCommand().Execute();
    }
}
