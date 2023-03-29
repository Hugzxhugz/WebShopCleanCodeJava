package org.example;

import org.example.MenuState.MainMenuState;

public class WebShop {

    public WebShop(){}

    public void Run(){
        MenuContextAndProxy context = new MenuContextAndProxy();
        context.setState(new MainMenuState());
        System.out.println("Welcome to the WebShop!");
        context.DisplayMenu();
    }
}
