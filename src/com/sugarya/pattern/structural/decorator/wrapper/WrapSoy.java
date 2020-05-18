package com.sugarya.pattern.structural.decorator.wrapper;

import com.sugarya.pattern.structural.decorator.Beverage;

public class WrapSoy extends Beverage {

    private Beverage mBeverage;

    public WrapSoy(Beverage mBeverage) {
        this.mBeverage = mBeverage;
        this.setDescription( "豆浆 " + mBeverage.getDescription());
    }

    @Override
    public int cost() {
        int basePrice = mBeverage.cost();
        return basePrice + 3;
    }
}
