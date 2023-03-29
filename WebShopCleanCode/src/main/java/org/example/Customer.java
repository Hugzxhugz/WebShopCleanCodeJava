package org.example;

import org.example.Builder.CustomerProperties;

import java.util.ArrayList;

public class Customer {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String address;
    private String phoneNumber;
    private int funds;
    private ArrayList<Order> orders;


    public Customer(String username, String password, CustomerProperties customerProperties)
    {
        this.username = username;
        this.password = password;
        this.firstName = customerProperties.firstName;
        this.lastName = customerProperties.lastName;
        this.email = customerProperties.email;
        this.age = customerProperties.age;
        this.address = customerProperties.address;
        this.phoneNumber = customerProperties.phoneNumber;
        orders = new ArrayList<>();
        funds = 0;
    }

    public String GetUsername() {
        return username;
    }

    public int GetFunds() {
        return funds;
    }

    public void AddFunds(int amount) {
        funds += amount;
    }

    public void RemoveFunds(int amount) {
        funds -= amount;
    }

    public ArrayList<Order> GetOrders() {
        return orders;
    }

    public boolean CanAfford(int price)
    {
        return funds >= price;
    }

    public boolean CheckPassword(String password)
    {
        if (password == null)
        {
            return true;
        }
        return password.equals(this.password);
    }

    public void PrintInfo()
    {
        System.out.println();
        System.out.print("Username: " + username + "");
        if (password != null)
        {
            System.out.print(", Password: " + password);
        }
        if (firstName != null)
        {
            System.out.print(", First Name: " + firstName);
        }
        if (lastName != null)
        {
            System.out.print(", Last Name: " + lastName);
        }
        if (email != null)
        {
            System.out.print(", Email: " + email);
        }
        if (age != -1)
        {
            System.out.print(", Age: " + age);
        }
        if (address != null)
        {
            System.out.print(", Address: " + address);
        }
        if (phoneNumber != null)
        {
            System.out.print(", Phone Number: " + phoneNumber);
        }
        System.out.println(", Funds: " + funds);
        System.out.println();
    }

    public void PrintOrders()
    {
        System.out.println();
        for (Order order : orders)
        {
            order.PrintInfo();
        }
        System.out.println();
    }
}
