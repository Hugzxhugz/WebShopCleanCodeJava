package org.example.Commands;

import org.example.Commands.MoveToMenuCommands.MoveToMainMenuCommand;
import org.example.Interface.ICommand;
import org.example.MenuContextAndProxy;

public class LogoutCommand implements ICommand {
    @Override
    public void Execute() {
        System.out.println();
        System.out.println(MenuContextAndProxy.GetInstance().GetLoggedInCustomer().GetUsername() + " logged out.");
        System.out.println();

        MenuContextAndProxy context = MenuContextAndProxy.GetInstance();
        context.SetLoggedInCustomer(null);

        new MoveToMainMenuCommand().Execute();
    }
}
