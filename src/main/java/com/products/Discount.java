package com.products;

interface Discount {
    double apply(Product product);
    String getDescription(Product product);
}
