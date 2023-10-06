package com.products;

public class MilkDiscount extends BaseDiscount {
    public MilkDiscount() {

    }

    public MilkDiscount(Discount nexDiscount) {
        this.nexDiscount = nexDiscount;
    }

    @Override
    public String getDescription(Product product) {
        return super.getDescription(product, "5% discount on milk,");
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
