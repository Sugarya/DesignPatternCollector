package com.sugarya.factory;

public abstract class AbstractCar{

    protected int width;
    protected int height;

    public AbstractCar(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public abstract void drive();

    public abstract void selfNavigation();

}
