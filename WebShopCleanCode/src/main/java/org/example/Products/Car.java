package org.example.Products;

import org.example.Abstract.ProductFactory;

public class Car extends ProductFactory {
    public Car() {
        super("Car", 2000000, 2);
    }

    @Override
    public String GetName() {
        return super.GetName();
    }

    @Override
    public int GetPrice() {
        return super.GetPrice();
    }

    @Override
    public int GetNumberInstock() {
        return super.GetNumberInstock();
    }
}
