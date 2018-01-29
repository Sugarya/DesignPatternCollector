package com.sugarya.base.stream;

import com.sugarya.base.stream.model.Dish;
import com.sugarya.utils.Out;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamClient {

    private static final List<Dish> DISH_LIST = new ArrayList<>();

    static {
        DISH_LIST.add(new Dish("pork", false, 800, Dish.Type.MEAT));
        DISH_LIST.add(new Dish("beef", false, 700, Dish.Type.MEAT));
        DISH_LIST.add(new Dish("chicken", false, 400, Dish.Type.MEAT));
        DISH_LIST.add(new Dish("french fries", true, 530, Dish.Type.OTHER));
        DISH_LIST.add(new Dish("rice", true, 350, Dish.Type.OTHER));
        DISH_LIST.add(new Dish("season fruit", true, 120, Dish.Type.OTHER));
        DISH_LIST.add(new Dish("pizza", true, 550, Dish.Type.OTHER));
        DISH_LIST.add(new Dish("prawns", false, 300, Dish.Type.FISH));
        DISH_LIST.add(new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    public static void main(String[] args) {
        testVersion15();
    }

    private static void testVersion1() {
        List<String> stringList = DISH_LIST.parallelStream()
                .filter(dish -> dish.getCalories() < 480)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

        Out.println(stringList);
    }

    private static void testVersion2() {
        List<String> resultList = DISH_LIST.stream()
                .filter(d -> d.getCalories() > 400)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        Out.println(resultList);
    }

    /**
     * distinct操作符
     */
    private static void testVersion3() {
        DISH_LIST.stream()
                .filter(d -> {
                    Out.println("filter");
                    return d.getCalories() > 400;
                })
                .map(d -> {
                    String name = d.getName();
                    Out.println("mapping name = " + name);
                    return name;
                })
                .limit(3)
                .distinct()
                .forEach(Out::println);
    }

    /**
     * 跳过 skip ／ limit
     */
    private static void testVersion4() {
        long count = DISH_LIST.stream()
                .filter(dish -> dish.getCalories() > 500)
                .skip(2)
                .count();
        Out.println("count = " + count);
    }

    /**
     * flatMap
     */
    private static void testVersion5() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new Integer[]{i, j}))
                .forEach(array -> Out.println(array[0] + " : " + array[1]));
    }

    /**
     * findAny & findFirst 差异
     */
    private static void testVersion6() {
        DISH_LIST.parallelStream()
                .filter(dish -> dish.getCalories() > 400)
                .findAny()
                .ifPresent(optional -> Out.println(optional.getName()));
    }

    /**
     * findAny & findFirst 差异
     */
    private static void testVersion7() {
        DISH_LIST.stream()
                .filter(dish -> dish.getCalories() > 400)
                .findAny()
                .ifPresent(optional -> Out.println(optional.getName()));
    }

    /**
     * reduce 归约 操作
     */
    private static void testVersion8() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        data.stream()
                .reduce((a, b) -> a + b)
                .ifPresent(Out::println);
    }


    /**
     * reduce 归约 操作
     */
    private static void testVersion9() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer reduce = data.stream()
                .reduce(100, Integer::sum);
        Out.println("reduce result = " + reduce);
    }


    private static void testVersion10() {
        int sum = DISH_LIST.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        Out.println("sum = " + sum);
    }

    private static void testVersion11() {
        OptionalInt max = DISH_LIST.stream()
                .mapToInt(Dish::getCalories)
                .max();
        max.ifPresent(System.out::println);
    }

    private static void testVersion12() {
        long count = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .count();
        Out.println("even number count = " + count);
    }

    private static void testVersion12_2() {
        long count = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0)
                .count();
        Out.println("odd number count = " + count);
    }

    /**
     * 寻找 勾股数
     */
    private static void testVersion13() {
        IntStream.rangeClosed(1, 500)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i, 500)
                        .filter(j -> Math.sqrt(i * i + j * j) % 1 == 0)
                        .boxed()
                        .map(j -> new int[]{i, j, (int) Math.sqrt(i * i + j * j)}))
                .forEach(array -> Out.println(array[0] + " " + array[1] + " " + array[2]));
    }

    /**
     * 寻找 勾股数
     */
    private static void testVersion13_2() {
        IntStream.rangeClosed(1, 500)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i, 500)
                        .mapToObj(j -> new double[]{i, j, Math.sqrt(i * i + j * j)}))
                .filter(array -> array[2] % 1 == 0)
                .forEach(array -> Out.println(array[0] + " " + array[1] + " " + array[2]));
    }

    /**
     * 生成斐波那契数列元组
     */
    private static void testVersion14() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(supplier -> Out.println("(" + supplier[0] + "，" + supplier[1] + ")"));
    }

    /**
     * 生成斐波那契数列
     */
    private static void testVersion14_2() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    /**
     * generate 有状态的生成斐波那契数列
     */
    private static void testVersion15() {
        IntStream.generate(new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int result = previous;
                int next = previous + current;
                previous = current;
                current = next;
                return result;
            }

        }).limit(20).forEach(System.out::println);
    }
}
