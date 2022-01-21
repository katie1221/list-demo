package com.example.listdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.listdemo.entity.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List集合分页：
 *      limit(long n) 方法用于返回前n条数据，
 *      skip(long n) 方法用于跳过前n条数据
 * @author qzz
 */
public class ListLimitSpike {

    public static void main(String[] args) {
        //构建测试数据
        List<User> list = new ArrayList<User>();
        list.add(new User("张丹",11,new BigDecimal(11)));
        list.add(new User("刘大",13,new BigDecimal(13)));
        list.add(new User("飒飒",16,new BigDecimal(16)));
        list.add(new User("斯蒂芬",11,new BigDecimal(11)));

        //获取用户列表，要求跳过第1条数据后的前3条数据
        list = list.stream().skip(1).limit(3).collect(Collectors.toList());

        //输出结果
        System.out.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat));
    }
}
