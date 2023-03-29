package org.example.MenuState.LogInOptions;

import org.example.Abstract.MenuStateFactory;
import org.example.Commands.MoveToMenuCommands.MoveToLoginMenuCommand;
import org.example.Customer;
import org.example.MenuContextAndProxy;

public class SetLoginState extends MenuStateFactory {


    public void DisplayMenu() {

        String username = MenuContextAndProxy.instance.GetUsername();
        String password = MenuContextAndProxy.instance.GetPassword();

        if (username == null || password == null ) {
            System.out.println("\nIncomplete data.\n");
        }
        else {
            for (Customer customer : MenuContextAndProxy.GetInstance().getCustomerList()) {
                if (username.equals(customer.GetUsername()) && customer.CheckPassword(password)) {
                    System.out.println();
                    System.out.println(customer.GetUsername() + " logged in.");
                    System.out.println();
                    MenuContextAndProxy.GetInstance().SetLoggedInCustomer(customer);
                    break;
                }
                else {
                System.out.println("\nInvalid credentials.\n");
                break;
                }
            }
        }
        new MoveToLoginMenuCommand().Execute();
    }
}
