package org.example.MenuState.LogInOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.MoveToMenuCommands.MoveToLoginMenuCommand;
import org.example.GetInputClass;
import org.example.MenuContextAndProxy;

public class SetUsernameState extends MenuStateFactory {

    String username;
    GetInputClass getInputClass = new GetInputClass();

    public SetUsernameState(){
        this.currentMenu = "Set Username Menu";
    }

    public void DisplayMenu() {
        System.out.println("A keyboard appears.");
        username = getInputClass.getString("Please input your username.");

        MenuContextAndProxy context = MenuContextAndProxy.GetInstance();
        context.SetUsername(username);

        new MoveToLoginMenuCommand().Execute();
    }
}
