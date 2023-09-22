package com.products;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount() {

    }

    public FridayDiscount(Discount nexDiscount) {
        this.nexDiscount = nexDiscount;
    }

    @Override
    public double apply(Product product) {
        double nextDiscountSum = 0;
        if(nexDiscount != null) {
            nextDiscountSum = nexDiscount.apply(product);
        }
        if(isApplicable(product)) {
            return nextDiscountSum + calculateDiscount(product);
        }
        return 0;
    }

    @Override
    public String getDescription(Product product) {
        String nextDiscountDescription = "";
        if(nexDiscount != null) {
            nextDiscountDescription = nexDiscount.getDescription(product);
        }
        if(isApplicable(product)) {
            return nextDiscountDescription + "10% discount on Fridays,";
        }
        return "";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * product.quantity() * 0.1;
    }
    
}
