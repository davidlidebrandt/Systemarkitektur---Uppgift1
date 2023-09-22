package com.products;

import java.time.DayOfWeek;
import java.time.LocalDate;

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

        GeneralDiscount milkDiscount = new GeneralDiscount((Product p) -> { return p.name() == "MILK";}, (Product p) -> {return p.price() * p.quantity() * 0.05;});
        GeneralDiscount quantityDiscount = new GeneralDiscount(milkDiscount, (Product p) -> {return p.quantity() > 4;}, (Product p) -> {return p.quantity() * 10.0;});
        GeneralDiscount allDiscounts = new GeneralDiscount(quantityDiscount, (Product p) -> {return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY;}, (Product p) -> {return p.price() * p.quantity() * 0.1;});

        System.out.println(allDiscounts.apply(milk));
        System.out.println(allDiscounts.apply(tv));
        System.out.println(allDiscounts.apply(shoe));
    }
}
