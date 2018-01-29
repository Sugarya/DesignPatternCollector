package com.sugarya.base.stream;

import com.sugarya.base.stream.model.Trader;
import com.sugarya.base.stream.model.Transaction;
import com.sugarya.utils.Out;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用流收集数据
 */
public class StreamClient3 {

    private static final List<Transaction> TRANSACTION_LIST = new ArrayList<>();

    static {
        TRANSACTION_LIST.add(new Transaction(new Trader("Brian", "Cambridge"), 2011, 300));
        TRANSACTION_LIST.add(new Transaction(new Trader("Raoul", "Cambridge"), 2012, 1000));
        TRANSACTION_LIST.add(new Transaction(new Trader("Raoul", "Cambridge"), 2011, 400));
        TRANSACTION_LIST.add(new Transaction(new Trader("Mario", "Milan"), 2012, 710));
        TRANSACTION_LIST.add(new Transaction(new Trader("Mario", "Milan"), 2011, 700));
        TRANSACTION_LIST.add(new Transaction(new Trader("Alan", "Cambridge"), 2012, 900));
    }

    public static void main(String[] args) {
        testVersion1();
    }

    private static void testVersion1() {
        TRANSACTION_LIST.stream()
                .collect(Collectors.groupingBy(Transaction::getYear))
                .forEach((key, list) -> {
                    Out.println("key = " + key);
                    Out.println(list.toString());
                });

    }

}
