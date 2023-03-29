package org.example.Commands.MoveToWaresOptionsCommands;

import org.example.Abstract.ProductFactory;
import org.example.Customer;
import org.example.Interface.ICommand;
import org.example.Interface.IMenuState;
import org.example.MenuContextAndProxy;
import org.example.MenuState.WaresOptions.PurchaseMenu;
import org.example.Order;

import java.time.LocalDateTime;

public class PurchaseProductCommand implements ICommand {
    private final ProductFactory product;
    public PurchaseProductCommand(ProductFactory product) {
        this.product = product;
    }

    @Override
    public void Execute() {

        Customer currentCustomer = MenuContextAndProxy.GetInstance().GetLoggedInCustomer();
        if (currentCustomer == null) {
            System.out.println("No user logged in.");
            return;
        }

        if (product.InStock()) {
            if (currentCustomer.CanAfford(product.GetPrice())) {
                currentCustomer.RemoveFunds(product.GetPrice());
                product.DecreaseStock();
                currentCustomer.GetOrders().add(new Order(product.GetName(), product.GetPrice(), LocalDateTime.now()));
                System.out.println();
                System.out.println("Successfully bought " + product.GetName());
                System.out.println();
            } else {
                System.out.println("\nYou cannot afford.\n");
            }
        } else {
            System.out.println("\nNot in stock.\n");
        }

        IMenuState purchaseMenu = new PurchaseMenu();
        purchaseMenu.DisplayMenu();
    }
}
