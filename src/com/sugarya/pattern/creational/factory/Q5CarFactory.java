package com.sugarya.pattern.creational.factory;

public class Q5CarFactory extends AbstractCarFactory {

    @Override
    public AbstractCar createCar(int width, int height) {
        return new Q5Car(width, height);
    }
}
