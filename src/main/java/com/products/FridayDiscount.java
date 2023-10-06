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
        return LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * product.quantity() * 0.1;
    }
    
}
