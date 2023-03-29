package org.example;

import java.time.LocalDateTime;

public class Order {
    private String name;
    private int boughtFor;
    private LocalDateTime purchaseTime;

    public Order(String name, int boughtFor, LocalDateTime purchaseTime)
    {
        this.name = name;
        this.boughtFor = boughtFor;
        this.purchaseTime = purchaseTime;
    }
    public void PrintInfo()
    {
        System.out.println(name + ", bought for " + boughtFor + "kr, time: " + purchaseTime + ".");
    }
}
