package org.example;

import org.example.Abstract.ProductFactory;
import org.example.Interface.IMenuState;

import java.util.ArrayList;

public class MenuContextAndProxy {
    private IMenuState currentState;

    public static MenuContextAndProxy instance;
    private Customer loggedInCustomer;
    private String username;
    private String password;

    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<ProductFactory> sortedProductsList = new ArrayList<>();

    public MenuContextAndProxy() {}
    public void setState(IMenuState state) {
        this.currentState = state;
    }

    public void DisplayMenu() {
        // display the current state's menu
        this.currentState.DisplayMenu();
    }

    public static MenuContextAndProxy GetInstance() {
        if (instance == null) {
            instance = new MenuContextAndProxy();
        }
        return instance;
    }

    public void SetLoggedInCustomer(Customer customer) {
        this.loggedInCustomer = customer;
    }

    public Customer GetLoggedInCustomer() {
        return loggedInCustomer;
    }
    public void SetUsername(String username) { this.username = username; }

    public String GetUsername() {
        return username;
    }

    public void SetPassword(String password) { this.password = password; }

    public String GetPassword() {
        return password;
    }

    public ArrayList<Customer> GetCustomerList() {
        return customerList;
    }

    public void addToCustomerList(Customer customer) {
        this.customerList.add(customer);
    }

    public ArrayList<ProductFactory> GetSortedProductsList(){
        return sortedProductsList;
    }

    public ArrayList<ProductFactory> SetProductsToSortedList(ArrayList<ProductFactory> newProductsList) {
        this.sortedProductsList = new ArrayList<>(newProductsList);
        return sortedProductsList;
    }

    public void PrintSortedProductList() {
        for (ProductFactory product : sortedProductsList) {
            System.out.println(product.GetName() + ": " + product.GetPrice() + "kr,  " +
                    product.GetNumberInstock() + " in stock.");
        }
        System.out.println(" ");
    }
}



