package org.example.Products;

import org.example.Abstract.ProductFactory;

public class Chair extends ProductFactory {
    public Chair() {
        super("Chair", 500, 2);
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
