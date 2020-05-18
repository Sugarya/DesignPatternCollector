package com.sugarya.client.structural.decorator;

import com.sugarya.pattern.structural.decorator.Beverage;
import com.sugarya.pattern.structural.decorator.Decaf;
import com.sugarya.pattern.structural.decorator.wrapper.WrapMilk;
import com.sugarya.pattern.structural.decorator.wrapper.WrapMocha;
import com.sugarya.utils.Out;

public class DecoratorClient {

    public void test(){
        Beverage beverage = new WrapMocha(new WrapMilk(new Decaf()));
        Out.print("名称：" + beverage.getDescription());
        System.out.println();
        Out.print("价格：" + beverage.cost());
    }
}
