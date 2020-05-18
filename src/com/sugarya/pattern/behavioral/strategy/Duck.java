package com.sugarya.pattern.behavioral.strategy;

import com.sugarya.pattern.behavioral.strategy.behavior.FlyBehavior;
import com.sugarya.pattern.behavioral.strategy.behavior.QuackBehavior;
import com.sugarya.utils.Out;

public abstract class Duck {

    private final static String TAG = Duck.class.getSimpleName();

    protected String name;
    protected QuackBehavior quackBehavior;
    protected FlyBehavior flyBehavior;

    public Duck(String name) {
        this.name = name;
    }

    public void swim(){
        Out.print(TAG + " "+ this.name + "鸭子在游泳");
    }

    public void performFly(){
        if(flyBehavior != null){
            flyBehavior.fly();
        }
    }

    public void performQuack() {
        if(quackBehavior != null){
            quackBehavior.quack();
        }
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    protected abstract void display();
}
