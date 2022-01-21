package com.example.listdemo.utils;

import com.alibaba.fastjson.JSON;
import com.example.listdemo.entity.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List集合去重：使用distinct()函数
 * 使用stream().map()提取List对象的某一列值及去重
 * @author qzz
 */
public class ListDistinct {

    public static void main(String[] args) {
        //构建测试数据
        List<User> list = new ArrayList<User>();
        list.add(new User("张三","000001",26,true,1.76, LocalDate.of(1996,1,18)));
        list.add(new User("小莉","000002",21,false,1.61, LocalDate.of(2001,1,18)));
        list.add(new User("李四","000003",22,true,1.83, LocalDate.of(2000,1,18)));
        list.add(new User("程曦","000004",20,false,1.64, LocalDate.of(2002,1,18)));
        list.add(new User("喜喜","000005",20,false,1.67, LocalDate.of(2002,1,18)));

        //输出list列表
//        User.printUsers(list);

        //1.提取某一列
        List<String> nameList = list.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(nameList));

        //2.从列表中提取age并去重
        List<Integer>  ageList = list.stream().map(User::getAge).distinct().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(ageList));
    }
}
