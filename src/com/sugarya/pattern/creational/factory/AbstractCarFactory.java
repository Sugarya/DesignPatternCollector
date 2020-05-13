package com.sugarya.pattern.creational.factory;

public abstract class AbstractCarFactory {

    protected abstract AbstractCar createCar(int width, int height);
}
