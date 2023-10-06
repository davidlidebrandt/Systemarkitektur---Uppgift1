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
        return super.getDescription(product, "10% discount on Fridays,");
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
