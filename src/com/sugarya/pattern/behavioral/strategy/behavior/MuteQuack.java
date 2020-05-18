package com.sugarya.pattern.behavioral.strategy.behavior;

import com.sugarya.utils.Out;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        Out.print("nothing quack");
    }

}
