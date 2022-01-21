package com.example.listdemo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author qzz
 */
@Data
public class User {

    /**
     * id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 工号
     */
    private String jobNumber;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * true:男 false：女
     */
    private Boolean  gender;
    /**
     * 身高
     */
    private Double  height;
    /**
     * 出生日期
     */
    private LocalDate birthday;
    /**
     * 成员数量
     */
    private BigDecimal familyMemberQuantity;

    public User(String name, String jobNumber, Integer age, Boolean gender, Double height, LocalDate birthday){
        this.name = name;
        this.jobNumber = jobNumber;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.birthday = birthday;
    }
    public User(String name,Integer age,BigDecimal familyMemberQuantity){
        this.name = name;
        this.age = age;
        this.familyMemberQuantity = familyMemberQuantity;
    }
    /**
     * 输出打印信息
     * @param list
     */
    public static void printUsers(List<User> list){
        System.out.println("[姓名]\t\t[工号]\t\t[性别]\t\t[年龄]\t\t[身高]\t\t[生日]");
        System.out.println("-----------------------------------------------------------------------");
        list.forEach(u-> System.out.println(printValue(u)));
        System.out.println(" ");
    }

    /***
     * 输出list结果集
     * @param user
     * @return
     */
    public static String printValue(User user){
        String str=String.format("%s\t\t\t%s\t\t%s\t\t%s\t\t\t%s\t\t%s",
                user.name,user.jobNumber,user.gender.toString(),user.age.toString(),
                user.height.toString(),user.birthday.toString());
        return str;
    }
}
