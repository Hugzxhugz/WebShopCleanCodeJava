package org.example.Products;

import org.example.Abstract.ProductFactory;

public class Computer extends ProductFactory {
    public Computer() {
        super("Computer", 100000, 2);
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
