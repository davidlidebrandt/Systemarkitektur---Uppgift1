package com.products;

public class App {
    public static void main(String[] args) {
        Product p = new Product("MILK", 100.0, 4);
        Discount fd = new FridayDiscount(new MilkDiscount());
        double d = fd.apply(p);
        System.out.println(d);
    }
}
