package com.example.listdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.listdemo.entity.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * List集合分组:通过Collectors.groupingBy可以分组指定字段
 * @author qzz
 */
public class ListGrouping {

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

        //示例2：list分组（通过groupingBy可以分组指定字段）
        System.out.println("###############################单字段分组##############################");

        //2.1单字段分组：按照gender分组
        Map<Boolean,List<User>> groupList = list.stream().collect(Collectors.groupingBy(User::getGender));
        //遍历结果集
        for(Map.Entry<Boolean,List<User>> entryUser :groupList.entrySet()){
            Boolean key = entryUser.getKey();
            List<User> entryUserList = entryUser.getValue();
            System.out.println("key："+key +",value:"+entryUserList.toString());
        }
        System.out.println("#############################################################");
        //知道key值，可如下输出分组的结果
        groupList.get(true).forEach(e->{
            System.out.println("男："+e.toString());
        });
        System.out.println("#############################################################");
        groupList.get(false).forEach(e->{
            System.out.println("女："+e.toString());
        });
        System.out.println("#############################################################");
        //2.2多字段分组(多个字段，用下划线拼接)：按照年龄、gender分组
        Map<Object,List<User>> groupList2 = list.stream().collect(Collectors.groupingBy(o ->{
            StringBuffer bf = new StringBuffer();
            bf.append(o.getAge()).append("_");
            bf.append(o.getGender());
            return bf.toString();
        }));
        System.out.println(JSON.toJSONString(groupList2, SerializerFeature.PrettyFormat));
    }

}
