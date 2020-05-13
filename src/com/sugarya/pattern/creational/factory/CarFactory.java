package com.sugarya.pattern.creational.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CarFactory {

    public static AbstractCar createQ3Car(int width, int height) {
        return new Q3Car(width, height);
    }

    public static AbstractCar createQ5Car(int width, int height) {
        return new Q5Car(width, height);
    }

    public static <T extends AbstractCar> T createCar(Class<T> clazz, int width, int height) {
        try {
            Class[] parameters = {int.class, int.class};
            Constructor<T> constructor = clazz.getConstructor(parameters);
            return constructor.newInstance(width, height);
        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
