package com.products;

public class QuantityDiscount extends BaseDiscount {
    public QuantityDiscount() {

    }

    public QuantityDiscount(Discount nexDiscount) {
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
            return nextDiscountDescription + "10kr discount per product if you buy at least 4,";
        }
        return "";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() > 4;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.quantity() * 10.0;
    }
    
}
