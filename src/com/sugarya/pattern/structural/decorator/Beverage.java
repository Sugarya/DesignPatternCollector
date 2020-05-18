package com.sugarya.pattern.structural.decorator;

public abstract class Beverage {
    private String description;

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract int cost();

}
