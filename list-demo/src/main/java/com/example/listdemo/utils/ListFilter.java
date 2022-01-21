package com.example.listdemo.utils;

import com.example.listdemo.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List集合过滤：使用filter方法可以过滤某些条件
 * @author qzz
 */
public class ListFilter {

    public static void main(String[] args) {
        //构建测试数据
        List<User> list = new ArrayList<>();
        list.add(new User("张三","000001",26,true,1.76, LocalDate.of(1996,1,18)));
        list.add(new User("小莉","000002",21,false,1.61, LocalDate.of(2001,1,18)));
        list.add(new User("李四","000003",22,true,1.83, LocalDate.of(2000,1,18)));
        list.add(new User("程曦","000004",20,false,1.64, LocalDate.of(2002,1,18)));
        list.add(new User("喜喜","000005",20,false,1.67, LocalDate.of(2002,1,18)));

        //输出list列表
        User.printUsers(list);

        //示例3：使用filter()过滤list

        //查找身高在1.8米及以上的男生
        List<User> teacherList = list.stream().filter(user -> user.getGender()
                && user.getHeight() >= 1.8).collect(Collectors.toList());
        //输出查找结果
        User.printUsers(teacherList);

        //查找年龄在20以上的女生
        List<User> tList = list.stream().filter(user -> !user.getGender()
                && user.getAge() >= 20).collect(Collectors.toList());
        //输出查找结果
        User.printUsers(tList);
    }
}
