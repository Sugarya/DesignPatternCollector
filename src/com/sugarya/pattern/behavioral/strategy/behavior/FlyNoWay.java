package com.sugarya.pattern.behavioral.strategy.behavior;

import com.sugarya.utils.Out;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        Out.print("can not fly");
    }
}
