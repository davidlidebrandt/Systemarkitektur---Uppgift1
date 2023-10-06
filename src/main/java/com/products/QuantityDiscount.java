package com.products;

public class QuantityDiscount extends BaseDiscount {
    public QuantityDiscount() {

    }

    public QuantityDiscount(Discount nexDiscount) {
        this.nexDiscount = nexDiscount;
    }

    @Override
    public String getDescription(Product product) {
        return super.getDescription(product, "10kr discount per product if you buy at least 4,");
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
