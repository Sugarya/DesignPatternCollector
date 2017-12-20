package com.sugarya;

import com.sugarya.builder.NutritionFacts;
import com.sugarya.factory.*;

public class Main {

    public static void main(String[] args) {
//        testBuilder();
//        testFactory();
//        testStaticFactory();
        testStaticFactory2();
    }

    /**
     * 多工厂模式
     */
    private static void testFactory(){
        Q3CarFactory q3CarFactory = new Q3CarFactory();
        AbstractCar q3Car = q3CarFactory.createCar(2100, 3200);
        q3Car.drive();
        q3Car.selfNavigation();

        Q5CarFactory q5CarFactory = new Q5CarFactory();
        AbstractCar q5Car = q5CarFactory.createCar(1600, 2900);
        q5Car.drive();
        q5Car.selfNavigation();
    }

    /**
     * 简单／静态工厂模式
     */
    private static void testStaticFactory(){
        AbstractCar q3Car = CarFactory.createQ3Car(1000,2000);
        AbstractCar q5Car = CarFactory.createQ5Car(1300, 2600);

        q3Car.drive();
        q3Car.selfNavigation();
        q5Car.drive();
        q5Car.selfNavigation();
    }

    /**
     * 简单／静态工厂模式
     */
    private static void testStaticFactory2(){
        Q3Car q3Car = CarFactory.createCar(Q3Car.class, 2000,3000);
        Q5Car q5Car = CarFactory.createCar(Q5Car.class, 2200, 3400);

        if(q3Car != null){
            q3Car.drive();
            q3Car.selfNavigation();
        }
        if(q5Car != null) {
            q5Car.drive();
            q5Car.selfNavigation();
        }
    }


    /**
     * 建造者模式
     */
    private static void testBuilder() {
        NutritionFacts facts = new NutritionFacts.Builder(800, 15)
                .setCalories(1)
                .setCarbohydrate(2)
                .setFat(3)
                .setSodium(10)
                .build();

        System.out.println("NutritionFacts = " + facts.toString());
    }
}
