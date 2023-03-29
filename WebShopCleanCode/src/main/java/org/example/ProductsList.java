package org.example;

import org.example.Abstract.ProductFactory;
import org.example.Products.*;

import java.util.ArrayList;

public class ProductsList {
    private ArrayList<ProductFactory> productsList = new ArrayList<>();


    public ProductsList() {}


    public void AddProduct(ProductFactory product) {
        productsList.add(product);
    }
    public ArrayList<ProductFactory> GetProductsList() {
        productsList = new ArrayList<>();
        AddProduct(new Mirror());
        AddProduct(new Car());
        AddProduct(new Candle());
        AddProduct(new Computer());
        AddProduct(new Game());
        AddProduct(new Painting());
        AddProduct(new Chair());
        AddProduct(new Table());
        AddProduct(new Bed());
        return productsList;
    }

    public void PrintProductList() {
        for (ProductFactory product : productsList) {
            System.out.println(product.GetName() + ": " + product.GetPrice() + "kr,  " +
                    product.GetNumberInstock() + " in stock.");
        }
        System.out.println(" ");
    }
}