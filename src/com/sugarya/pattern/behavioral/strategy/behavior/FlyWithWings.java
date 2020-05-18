package com.sugarya.pattern.behavioral.strategy.behavior;

import com.sugarya.utils.Out;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        Out.print("fly with wings");
    }
}
