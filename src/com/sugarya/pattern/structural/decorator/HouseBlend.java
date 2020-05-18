package com.sugarya.pattern.structural.decorator;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.setDescription("综合咖啡");
    }

    @Override
    public int cost() {
        return 26;
    }
}
