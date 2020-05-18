package com.sugarya.pattern.structural.decorator.wrapper;

import com.sugarya.pattern.structural.decorator.Beverage;

public class WrapMocha extends Beverage {

    private Beverage mBeverage;

    public WrapMocha(Beverage mBeverage) {
        this.mBeverage = mBeverage;
        this.setDescription( "巧克力 " + mBeverage.getDescription());
    }


    @Override
    public int cost() {
        int basePrice = mBeverage.cost();
        return basePrice + 10;
    }
}
