package com.sugarya.pattern.structural.decorator.wrapper;

import com.sugarya.pattern.structural.decorator.Beverage;

public class WrapMilk extends Beverage  {

    private Beverage mBeverage;

    public WrapMilk(Beverage mBeverage) {
        this.mBeverage = mBeverage;
        this.setDescription( "牛奶 " + mBeverage.getDescription());
    }

    @Override
    public int cost() {
        int basePrice = mBeverage.cost();
        return basePrice + 5;
    }
}
