package com.sugarya.pattern.structural.decorator;

public class Decaf extends Beverage {

    public Decaf() {
        this.setDescription("脱因咖啡");
    }

    @Override
    public int cost() {
        return 30;
    }

}
