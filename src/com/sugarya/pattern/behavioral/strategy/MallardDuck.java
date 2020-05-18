package com.sugarya.pattern.behavioral.strategy;

import com.sugarya.pattern.behavioral.strategy.behavior.ChipperQuack;
import com.sugarya.pattern.behavioral.strategy.behavior.FlyWithWings;
import com.sugarya.utils.Out;

public class MallardDuck extends Duck{

    public MallardDuck(String name) {
        super(name);
        super.flyBehavior = new FlyWithWings();
        super.quackBehavior = new ChipperQuack();
    }

    @Override
    protected void display() {
        Out.print(super.name + " 绿头鸭子");
    }


}
