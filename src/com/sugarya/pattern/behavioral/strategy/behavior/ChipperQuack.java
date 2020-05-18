package com.sugarya.pattern.behavioral.strategy.behavior;

import com.sugarya.utils.Out;

public class ChipperQuack implements QuackBehavior {

    @Override
    public void quack() {
        Out.print("ChipperQuack 吱吱叫");
    }
}
