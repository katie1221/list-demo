package com.example.listdemo.utils;


import java.util.ArrayList;
import java.util.List;

/**
 * List集合：limit(long n) 方法用于限制打印出的数据个数为n
 * @author qzz
 */
public class ListLimit {

    public static void main(String[] args) {
        limit(3);
    }

    public static void limit(long n){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.stream().limit(n).forEach(integer -> System.out.println("integer = " + integer));
    }
}
