package com.products;

public class MilkDiscount extends BaseDiscount {
    public MilkDiscount() {

    }

    public MilkDiscount(Discount nexDiscount) {
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
            return nextDiscountDescription + "5% discount on milk,";
        }
        return "";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.name() == "MILK";
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * product.quantity() * 0.05;
    }
    
}
