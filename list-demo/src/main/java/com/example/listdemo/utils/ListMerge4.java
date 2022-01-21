package com.example.listdemo.utils;

import com.example.listdemo.entity.Student;
import com.example.listdemo.entity.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 一个list 集合合并去重求和
 * @author qzz
 */
public class ListMerge4 {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        Student s1 = new Student();
        s1.setId("s1");
        s1.setNums(1);
        s1.setSums(1);
        list.add(s1);

        s1 = new Student();
        s1.setId("s1");
        s1.setNums(2);
        s1.setSums(3);
        list.add(s1);

        s1 = new Student();
        s1.setId("s2");
        s1.setNums(3);
        s1.setSums(5);
        list.add(s1);

        //合并去重求和
        List<Student> result = merge(list);
        result.stream().forEach(e->{
            System.out.println("id:"+e.getId()+",nums:"+e.getNums()+",sums:"+e.getSums());
        });

    }

    /**
     * 将id进行合并nums, sums 相加道回合并后的集合使用Java8的流进行处理
     * @return
     */
    public static List<Student> merge(List<Student> list){

        List<Student> result = list.stream()
                .collect(Collectors.toMap(Student::getId, a->a,(o1,o2)->{
                    o1.setNums(o1.getNums()+o2.getNums());
                    o1.setSums(o1.getSums()+o2.getSums());
                    return o1;
                })).values().stream().collect(Collectors.toList());
        return result;
    }


}
