package org.example.Abstract;

public abstract class ProductFactory {

    private String name;
    private int price;
    private int numberInstock;

    public ProductFactory(String name, int price, int numberInStock){
        this.name = name;
        this.price = price;
        this.numberInstock = numberInStock;
    }

    public String GetName(){
        return this.name;
    }

    public int GetPrice(){
        return this.price;
    }

    public int GetNumberInstock() {
        return numberInstock;
    }

    public void DecreaseStock() {
        numberInstock--;
    }

    public boolean InStock()
    {
        return numberInstock > 0;
    }
}

