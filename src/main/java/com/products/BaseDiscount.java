package com.products;

public abstract class BaseDiscount implements Discount {
    protected Discount nexDiscount;
    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);
}
