package org.example.MenuState.LogInOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.MoveToMenuCommands.MoveToLoginMenuCommand;
import org.example.GetInputClass;
import org.example.MenuContextAndProxy;

public class SetPasswordState extends MenuStateFactory {

    String password;
    GetInputClass getInputClass = new GetInputClass();

    public SetPasswordState(){
        this.currentMenu = "Set Password Menu";
    }

    public void DisplayMenu() {
        System.out.println("A keyboard appears.");
        password = getInputClass.GetString("Please input your password.");

        MenuContextAndProxy context = MenuContextAndProxy.GetInstance();
        context.SetPassword(password);

        new MoveToLoginMenuCommand().Execute();
    }
}
