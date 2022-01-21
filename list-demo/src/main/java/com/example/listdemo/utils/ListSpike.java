package com.example.listdemo.utils;


import java.util.ArrayList;
import java.util.List;

/**
 * List集合：skip(long n) 方法用于跳过前n条数据
 * @author qzz
 */
public class ListSpike {

    public static void main(String[] args) {
        skip(7);
    }

    public static void skip(long n){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.stream().skip(n).forEach(integer -> System.out.println("integer = " + integer));
    }
}
