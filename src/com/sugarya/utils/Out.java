package com.sugarya.utils;

import java.util.List;
import java.util.Set;

public class Out {

    public static void println(String message){
        System.out.println(message);
    }

    public static void println(int message){
        System.out.println(message);
    }

    public static <T> void println(List<T> list){
        if(list == null){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(T t : list){
            sb.append(t.toString()+ "\n");
        }
        println(sb.toString());
    }

    public static <T> void println(Set<T> set){
        if(set == null){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(T t : set){
            sb.append(t.toString()+ "\n");
        }
        println(sb.toString());
    }

    public static void print(String message){
        System.out.print(message);
    }

    public static <T> void print(List<T> list){
        if(list == null){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(T t : list){
            sb.append(t.toString()+ " ");
        }
        println(sb.toString());
    }


}
