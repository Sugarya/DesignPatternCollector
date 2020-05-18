package com.sugarya.pattern.structural.decorator;

public class Espresso extends Beverage {

    public Espresso() {
        this.setDescription("加浓咖啡");
    }

    @Override
    public int cost() {
        return 25;
    }

}
