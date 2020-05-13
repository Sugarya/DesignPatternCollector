package com.sugarya.client.creational;

import com.sugarya.pattern.creational.builder.NutritionFacts;

public class BuilderClient {
    /**
     * 建造者模式
     */
    public void test() {
        NutritionFacts facts = new NutritionFacts.Builder(800, 15)
                .setCalories(1)
                .setCarbohydrate(2)
                .setFat(3)
                .setSodium(10)
                .build();

        System.out.println("NutritionFacts = " + facts.toString());
    }
}
