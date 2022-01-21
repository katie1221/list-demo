package com.example.listdemo.utils;

import com.example.listdemo.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List集合遍历
 * @author qzz
 */
public class ListTraverse {

    public static void main(String[] args) {
        //构建测试数据
        List<User> list = new ArrayList<>();
        list.add(new User("张三","000001",26,true,1.76, LocalDate.of(1996,1,18)));
        list.add(new User("小莉","000002",21,false,1.61, LocalDate.of(2001,1,18)));
        list.add(new User("李四","000003",22,true,1.83, LocalDate.of(2000,1,18)));
        list.add(new User("程曦","000004",20,false,1.64, LocalDate.of(2002,1,18)));

        //输出list列表
        User.printUsers(list);

        //示例1：list遍历
        System.out.println("###############################方式一##############################");
        // 方式一：for循环遍历
        for(int i=0;i<list.size();i++){
            User user = list.get(i);
            System.out.println("姓名："+list.get(i).getName());
        }
        System.out.println("###############################方式二##############################");
        // 方式二：for
        for(User user:list){
            System.out.println("姓名："+user.getName());
        }
        System.out.println("###############################方式三#############################");
        // 方式三：iterator
        Iterator<User> it = list.iterator();
        while(it.hasNext()){
            System.out.println("姓名："+it.next().getName());
        }
        System.out.println("###############################方式四##############################");
        // 方式四：foreach（jdk1.8之后）
        list.forEach(u->{
            System.out.println("姓名："+u.getName());
        });
    }

}
