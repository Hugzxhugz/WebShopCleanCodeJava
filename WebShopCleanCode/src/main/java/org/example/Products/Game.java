package org.example.Products;

import org.example.Abstract.ProductFactory;

public class Game extends ProductFactory {
    public Game() {
        super("Game", 599, 2);
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
