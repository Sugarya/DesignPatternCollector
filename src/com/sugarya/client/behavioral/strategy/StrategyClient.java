package com.sugarya.client.behavioral.strategy;

import com.sugarya.pattern.behavioral.strategy.RedheadDuck;
import com.sugarya.pattern.behavioral.strategy.RubberDuck;
import com.sugarya.pattern.behavioral.strategy.behavior.MuteQuack;

public class StrategyClient {

    public void test(){
        RubberDuck rubberDuck = new RubberDuck("橡皮鸭");
        rubberDuck.performFly();

        RedheadDuck redheadDuck = new RedheadDuck("红头鸭");
        redheadDuck.performQuack();

        redheadDuck.setQuackBehavior(new MuteQuack());
        redheadDuck.performQuack();
    }
}
