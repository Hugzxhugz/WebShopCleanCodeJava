package org.example;

import org.example.Abstract.ProductFactory;
import org.example.Builder.CustomerProperties;
import org.example.Products.*;

import java.util.ArrayList;

public class Database {
    // We just pretend this accesses a real database.
    private ArrayList<ProductFactory> productsInDatabase;
    private ArrayList<Customer> customersInDatabase;
    public Database()
    {
        productsInDatabase = new ArrayList<ProductFactory>();
        productsInDatabase.add(new Mirror());
        productsInDatabase.add(new Car());
        productsInDatabase.add(new Candle());
        productsInDatabase.add(new Computer());
        productsInDatabase.add(new Game());
        productsInDatabase.add(new Painting());
        productsInDatabase.add(new Chair());
        productsInDatabase.add(new Table());
        productsInDatabase.add(new Bed());

        customersInDatabase = new ArrayList<Customer>();
        CustomerProperties customerProperties1 = new CustomerProperties("Jimmy",
                "Jamesson","jj@mail.com", 22, "Big Street 5", "123456789");
        customersInDatabase.add(new Customer("jimmy", "jimisthebest", customerProperties1));
        CustomerProperties customerProperties2 = new CustomerProperties("Jake",
                null, null, 0, null, null);
        customersInDatabase.add(new Customer("jake", "jake123", customerProperties2));
    }

    public ArrayList<ProductFactory> GetProducts()
    {
        return productsInDatabase;
    }

    public ArrayList<Customer> GetCustomers()
    {
        return customersInDatabase;
    }
}
