package com.products;

import java.util.function.Function;

public class GeneralDiscount {
    GeneralDiscount nextGeneralDiscount;
    Function<Product, Boolean> isApplicable;
    Function<Product, Double> calculateDiscount;

    public GeneralDiscount(Function<Product, Boolean> isApplicable, Function<Product, Double> calculateDiscount) {
        this.isApplicable = isApplicable;
        this.calculateDiscount = calculateDiscount;
    }

    public GeneralDiscount(GeneralDiscount nextGeneralDiscount,
            Function<Product, Boolean> isApplicable, Function<Product, Double> calculateDiscount) {
        this.nextGeneralDiscount = nextGeneralDiscount;
        this.isApplicable = isApplicable;
        this.calculateDiscount = calculateDiscount;
    }

    public double apply(Product product) {
        double nextDiscountSum = 0;
        if (nextGeneralDiscount != null) {
            nextDiscountSum = nextGeneralDiscount.apply(product);
        }

        if (isApplicable.apply(product)) {
            nextDiscountSum += calculateDiscount.apply(product);
        }
        return nextDiscountSum;
    }

}
