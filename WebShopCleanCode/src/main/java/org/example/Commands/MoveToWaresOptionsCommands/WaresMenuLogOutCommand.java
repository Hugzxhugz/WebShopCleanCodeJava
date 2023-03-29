package org.example.Commands.MoveToWaresOptionsCommands;
import org.example.Commands.MoveToMenuCommands.MoveToWaresMenuCommand;
import org.example.Interface.ICommand;
import org.example.MenuContextAndProxy;

public class WaresMenuLogOutCommand implements ICommand {
    @Override
    public void Execute() {
        System.out.println();
        System.out.println(MenuContextAndProxy.GetInstance().GetLoggedInCustomer().GetUsername() + " logged out.");
        System.out.println();

        MenuContextAndProxy context = MenuContextAndProxy.GetInstance();
        context.SetLoggedInCustomer(null);

        new MoveToWaresMenuCommand().Execute();

    }
}
