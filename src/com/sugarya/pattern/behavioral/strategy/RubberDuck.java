package com.sugarya.pattern.behavioral.strategy;

import com.sugarya.pattern.behavioral.strategy.behavior.ChipperQuack;
import com.sugarya.pattern.behavioral.strategy.behavior.FlyNoWay;
import com.sugarya.utils.Out;

public class RubberDuck extends Duck {

    public RubberDuck(String name) {
        super(name);
        super.flyBehavior = new FlyNoWay();
        super.quackBehavior = new ChipperQuack();
    }

    @Override
    protected void display() {
        Out.print(super.name + " 黄色橡皮鸭");
    }


}
