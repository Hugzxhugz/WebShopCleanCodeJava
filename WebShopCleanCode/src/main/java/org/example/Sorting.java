package org.example;

import org.example.Abstract.ProductFactory;

import java.util.ArrayList;

public class Sorting {


    public ArrayList<ProductFactory> SortProductsByNameAscending(ArrayList<ProductFactory> productList) {
        ArrayList<ProductFactory> sortedList = new ArrayList<>(productList);
        for (int i = 1; i < sortedList.size(); i++) {
            ProductFactory temp = sortedList.get(i);
            int j = i - 1;
            while (j >= 0 && sortedList.get(j).GetName().compareTo(temp.GetName()) > 0) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, temp);
        }
        return sortedList;
    }


    public ArrayList<ProductFactory> SortProductsByNameDescending(ArrayList<ProductFactory> productList) {

        ArrayList<ProductFactory> sortedList = new ArrayList<>(productList);

        for (int i = 1; i < sortedList.size(); i++) {
            ProductFactory temp = sortedList.get(i);
            int j = i - 1;
            while (j >= 0 && sortedList.get(j).GetName().compareTo(temp.GetName()) < 0) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, temp);
        }

        return sortedList;
    }

    public ArrayList<ProductFactory> SortProductsByPriceAscending(ArrayList<ProductFactory> productList) {

        ArrayList<ProductFactory> sortedList = new ArrayList<>(productList);

        for (int i = 1; i < sortedList.size(); i++) {
            ProductFactory temp = sortedList.get(i);
            int j = i - 1;
            while (j >= 0 && sortedList.get(j).GetPrice() > temp.GetPrice()) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, temp);
        }

        return sortedList;
    }


    public ArrayList<ProductFactory> SortProductsByPriceDescending(ArrayList<ProductFactory> productList) {

        ArrayList<ProductFactory> sortedList = new ArrayList<>(productList);

        for (int i = 1; i < sortedList.size(); i++) {
            ProductFactory temp = sortedList.get(i);
            int j = i - 1;
            while (j >= 0 && sortedList.get(j).GetPrice() < temp.GetPrice()) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, temp);
        }

        return sortedList;
    }



}
