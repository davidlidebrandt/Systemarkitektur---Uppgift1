package com.products;

public class MilkDiscount extends BaseDiscount {

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.name() == "MILK";
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.05;
    }
    
}
