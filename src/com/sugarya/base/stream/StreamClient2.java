package com.sugarya.base.stream;

import com.sugarya.base.stream.model.Trader;
import com.sugarya.base.stream.model.Transaction;
import com.sugarya.utils.Out;

import java.util.*;
import java.util.stream.Collectors;

public class StreamClient2 {

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
        testPractice8();
    }

    /**
     * 找出2011年的所有交易并按交易额排序
     */
    private static void testPractice1(){
        List<Transaction> transactionList = TRANSACTION_LIST.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        Out.print(transactionList);
    }

    /**
     * 交易员都在哪些不同的城市工作过
     */
    private static void testPractice2(){
        Set<String> collect = TRANSACTION_LIST.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toSet());
        Out.println(collect);

        List<String> collectList = TRANSACTION_LIST.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        Out.println(collectList);
    }

    /**
     * 查找所有来自剑桥的交易员，并按姓名排序
     */
    private static void testPractice3(){
        List<Trader> collect = TRANSACTION_LIST.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        Out.println(collect);
    }

    /**
     * 返回所有交易员的姓名字符串，按字母顺序排序
     */
    private static void testPractice4(){
        String reduce = TRANSACTION_LIST.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        Out.println(reduce);
    }

    /**
     * 有没有交易员在米兰工作
     */
    private static void testPratice5(){
        boolean match = TRANSACTION_LIST.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        Out.println("match = " + match);
    }

    /**
     * 打印生活在剑桥的交易员的所有交易额
     */
    private static void testPractice6(){
        List<Integer> collect = TRANSACTION_LIST.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .collect(Collectors.toList());
        Out.println(collect);
    }

    /**
     * 所有交易中，最高的交易额是多少
     */
    private static void testPractice7(){
        Optional<Integer> reduce = TRANSACTION_LIST.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        reduce.ifPresent(System.out::println);
    }

    /**
     * 找到交易额最小交易
     */
    private static void testPractice8(){
        Optional<Transaction> min = TRANSACTION_LIST.stream()
                .min(Comparator.comparing(Transaction::getValue));
        min.ifPresent(System.out::println);
    }

}
