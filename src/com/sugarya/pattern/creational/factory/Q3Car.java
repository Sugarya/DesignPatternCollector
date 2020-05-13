package com.sugarya.pattern.creational.factory;

public class Q3Car extends AbstractCar {

    public Q3Car(int width,int height) {
        super(width, height);
    }

    @Override
    public void drive() {
        System.out.println("Q3 启动 width = " + width + " height = " + height);
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q3 自动巡航");
    }
}
