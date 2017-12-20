package com.sugarya.factory;

public class Q3CarFactory extends AbstractCarFactory {

    @Override
    public AbstractCar createCar(int width, int height) {
        return new Q3Car(width, height);
    }
}
