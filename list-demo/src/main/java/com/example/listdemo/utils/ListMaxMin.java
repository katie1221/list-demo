package com.example.listdemo.utils;

import com.example.listdemo.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * List集合最值：使用jdk8的Stream来获取list集合的最小值、最大值、总和、平均数
 * @author qzz
 */
public class ListMaxMin {

    public static void main(String[] args) {
        //构建测试数据
        List<User> list = new ArrayList<User>();
        list.add(new User("张丹",11,new BigDecimal(11)));
        list.add(new User("刘大",13,new BigDecimal(13)));
        list.add(new User("飒飒",16,new BigDecimal(16)));
        list.add(new User("斯蒂芬",11,new BigDecimal(11)));

        //获取用户年龄的最大、最小、总和、平均值
        int max = list.stream().mapToInt(u->u.getAge()).max().getAsInt();
        int min = list.stream().mapToInt(u->u.getAge()).min().getAsInt();
        //求和
        //求和：分基本类型和大数据类型，基本类型先mapToInt方法,然后调用sun方法；大数类型使用reduce调用BigDecimal::add方法
        //基本类型求和
        int sum = list.stream().mapToInt(u->u.getAge()).sum();
        //BigDecimal求和
        BigDecimal totalQuantity = list.stream().map(u->u.getFamilyMemberQuantity()).reduce(BigDecimal.ZERO,BigDecimal::add);

        double avg = list.stream().mapToInt(u->u.getAge()).average().getAsDouble();

        System.out.println("年龄最大值："+max+"\n年龄最小值："+min);
        System.out.println("年龄总和："+sum+"\n年龄平均值："+avg);
        System.out.println("成员数量总和："+totalQuantity);
    }
}
