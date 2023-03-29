package org.example.Products;

import org.example.Abstract.ProductFactory;

public class Table extends ProductFactory {
    public Table() {
        super("Table", 1000, 2);
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
