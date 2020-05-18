package com.sugarya.pattern.structural.decorator;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        this.setDescription("焦炒咖啡");
    }

    @Override
    public int cost() {
        return 20;
    }
}
