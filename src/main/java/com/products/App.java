package com.products;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("MILK", 100.0, 6);
        Product tv = new Product("tv", 100.0, 5);
        Product shoe = new Product("Shoe", 100, 1);
        Discount discount = new FridayDiscount(new QuantityDiscount(new MilkDiscount()));
        
        System.out.println(discount.apply(milk));
        System.out.println(discount.getDescription(milk));
        System.out.println(discount.apply(tv));
        System.out.println(discount.getDescription(tv));
        System.out.println(discount.apply(shoe));
        System.out.println(discount.getDescription(shoe));
    }
}
