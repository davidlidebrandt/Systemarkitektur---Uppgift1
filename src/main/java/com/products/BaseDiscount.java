package com.products;

public abstract class BaseDiscount implements Discount {
    protected Discount nexDiscount;
    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);
    
    public double apply(Product product) {
        double nextDiscountSum = 0;
        if(nexDiscount != null) {
            nextDiscountSum = nexDiscount.apply(product);
        }
        if(isApplicable(product)) {
            nextDiscountSum += calculateDiscount(product);
        }
        return nextDiscountSum;
    }

    public String getDescription(Product product, String description) {
        String nextDiscountDescription = "";
        if(nexDiscount != null) {
            nextDiscountDescription = nexDiscount.getDescription(product);
        }
        if(isApplicable(product)) {
            nextDiscountDescription += description;
        }
        return nextDiscountDescription;
    }
}
