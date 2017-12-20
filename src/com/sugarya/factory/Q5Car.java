package com.sugarya.factory;

public class Q5Car extends AbstractCar {

    public Q5Car(int width, int height) {
        super(width, height);
    }

    @Override
    public void drive() {
        System.out.println("Q5 启动 width = " + width + " height = " + height);
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q5 自动巡航");
    }
}
