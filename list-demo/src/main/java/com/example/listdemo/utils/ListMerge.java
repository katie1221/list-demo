package com.example.listdemo.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * List集合合并：合并两个list<map>,并将userId相同的其它属性合并
 * @author qzz
 */
public class ListMerge {

    public static void main(String[] args) {
        mergeList();
    }

    /**
     * @Description: 合并两个list<map>,并将userId相同的其它属性合并
     * @Title: mergeList
     * @param: @return
     * @return: List<Map<String,Object>>
     * @throws
     */
    public static List<Map<String,Object>> mergeList(){
        //构建list1集合数据
        List<Map<String,Object>> list1 = new ArrayList<>();
        Map<String,Object> data=new HashMap<>();
        data.put("userId","100001");
        data.put("userName","唐僧");
        list1.add(data);

        data=new HashMap<>();
        data.put("userId","100002");
        data.put("userName","八戒");
        list1.add(data);

        data=new HashMap<>();
        data.put("userId","100003");
        data.put("userName","悟空");
        list1.add(data);

        data=new HashMap<>();
        data.put("userId","100004");
        data.put("userName","沙僧");
        list1.add(data);

        //构建list2集合数据
        List<Map<String,Object>> list2 = new ArrayList<>();
        data=new HashMap<>();
        data.put("userId","100001");
        data.put("gender","男");
        data.put("age",20);
        list2.add(data);

        data=new HashMap<>();
        data.put("userId","100002");
        data.put("gender","雄");
        data.put("age",1000);
        list2.add(data);

        data=new HashMap<>();
        data.put("userId","100003");
        data.put("gender","雄");
        data.put("age",600);
        list2.add(data);

        data=new HashMap<>();
        data.put("userId","100004");
        data.put("gender","男");
        data.put("age",800);
        list2.add(data);

        //steam():把一个源数据，可以是集合，数组，I/O channel， 产生器generator 等，转化成流。
        //forEach():迭代流中的每个数据
        //map():用于映射每个元素到对应的结果
        //filter():用于通过设置的条件过滤出元素
        //Collectors(): 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：

        //属性合并：根据userId把list2合并到list1的结果集中
        List<Map<String, Object>> list = list1.stream().map(m -> {
            list2.stream().filter(m2-> Objects.equals(m.get("userId"),m2.get("userId"))).forEach(m2-> {
                m.put("gender",m2.get("gender"));
                m.put("age",m2.get("age"));
            });
            return m;
        }).collect(Collectors.toList());

        //遍历输出合并后的结果集
        for(Map<String, Object> map:list){
            System.out.println(map.toString());
        }
        return list;
    }
}
