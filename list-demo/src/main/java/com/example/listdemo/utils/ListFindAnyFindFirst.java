package com.example.listdemo.utils;

import com.example.listdemo.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * List集合获取第一条数据：使用 findAny() 和 findFirst() 获取第一条数据
 * @author qzz
 */
public class ListFindAnyFindFirst {

    public static void main(String[] args) {
        //构建测试数据
        List<User> list = new ArrayList<User>();
        list.add(new User("张丹",11,new BigDecimal(11)));
        list.add(new User("刘大",13,new BigDecimal(13)));
        list.add(new User("飒飒",16,new BigDecimal(16)));
        list.add(new User("斯蒂芬",11,new BigDecimal(11)));

        //1. findAny():将返回集合中符合条件的任意一个元素。
        //findAny()Java Stream的方法为该流的某些元素返回一个Optional，如果该流为空，则返回一个空的Optional。在这里，Optional是一个容器对象，可以包含也可以不包含非null值
        Optional<User> userOptional = list.stream().findAny();
        System.out.println(userOptional.get());

        //1. findFirst():获取第一条数据
        //如果一个集合数据是有序的，而且你要查找符合条件的第一条数据。这时用findFirst是比较合适的
        Optional<User> userOptional1 = list.stream().findFirst();
        System.out.println(userOptional1.get());

        /***
         * 问题解答：findFirst和findAny如何选择？
         * （1）如果你不关心返回的是哪一个数据，只要符合条件的就行，那就用findAny。
         * 而且在并行流上，findAny限制更少。
         * （2）如果你关心集合的顺序，要返回符合条件的第一个元素，那就用findFirst。
         */
    }
}
