package com.example.listdemo.utils;

import com.example.listdemo.entity.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * List集合排序：单字段排序
 * @author qzz
 */
public class ListSortMultiple {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Ticket> list = new ArrayList<Ticket>();
        Ticket data = new Ticket();
        data.setTicketName("测试券1");
        data.setConvertible("0");
        data.setCreateDate(sdf.parse("2022-01-05 22:56:03"));
        data.setExEndTime(sdf.parse("2022-01-31 23:59:59"));
        data.setExIntegral("1");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("11");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试券2");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-05 22:54:11"));
        data.setExEndTime(sdf.parse("2022-01-31 23:59:59"));
        data.setExIntegral("1");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("31");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试券3");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-05 22:52:06"));
        data.setExEndTime(sdf.parse("2022-01-31 23:59:59"));
        data.setExIntegral("1");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("41");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试券4");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-07 17:03:42"));
        data.setExEndTime(sdf.parse("2022-01-31 23:59:59"));
        data.setExIntegral("10");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("12");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试券5");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-05 14:10:09"));
        data.setExEndTime(sdf.parse("2022-01-15 23:59:59"));
        data.setExIntegral("0");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("11");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试券6");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-05 09:48:43"));
        data.setExEndTime(sdf.parse("2022-01-12 23:59:59"));
        data.setExIntegral("0");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("8");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试券7");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-05 22:58:27"));
        data.setExEndTime(sdf.parse("2022-01-31 23:59:59"));
        data.setExIntegral("1200");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("16");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试券8");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-10 17:56:44"));
        data.setExEndTime(sdf.parse("2022-01-31 23:59:59"));
        data.setExIntegral("1000");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("21");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试券9");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-05 21:54:37"));
        data.setExEndTime(sdf.parse("2022-01-12 23:59:59"));
        data.setExIntegral("9");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("2");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试1券");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2022-01-11 11:27:11"));
        data.setExEndTime(sdf.parse("2022-01-12 23:59:59"));
        data.setExIntegral("1000");
        data.setExMoney("0.01");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("1");
        list.add(data);

        data = new Ticket();
        data.setTicketName("测试2券");
        data.setConvertible("1");
        data.setCreateDate(sdf.parse("2021-12-23 14:35:57"));
        data.setExEndTime(sdf.parse("2022-01-13 23:59:59"));
        data.setExIntegral("50");
        data.setExMoney("0");
        data.setIsSoldOut("1");
        data.setIsSpike("0");
        data.setSaleNum("2");
        list.add(data);

        for(Ticket ticket:list){
            System.out.println(ticket.getTicketName()+","+ticket.getConvertible()+","+ticket.getSaleNum()+","+ticket.getBatchAvailableNum());
        }
        System.out.println("--------------------------------------list------------------------------------");

        //jdk8 组合降序排序
        //isSoldOut desc,convertible desc,isSpike desc,saleNum desc,exIntegral desc,exMoney desc,exEndTime asc,createDate desc
        //Comparator.reverseOrder():降序 Comparator.naturalOrder()：升序

        //方式一：多个字段排序（多余两个）
        //先以属性SaleNum降序,再进行属性BatchAvailableNum升序 多个字段 后面追加即可
//        List<Ticket> sortList =  list.stream()
//                .sorted(Comparator.comparing(Ticket::getSaleNum,Comparator.reverseOrder())
//                        .thenComparing(e->{
//                            return Integer.valueOf(e.getBatchAvailableNum());
//                        },Comparator.naturalOrder())
//                        .thenComparing(e->{
//                            return Integer.valueOf(e.getConvertible());
//                        },Comparator.reverseOrder())
//                )
//                .collect(Collectors.toList());

        //方式二：多个字段排序（多余两个）
        Collections.sort(list, Comparator.comparing(Ticket::getIsSoldOut,Comparator.reverseOrder())
                .thenComparing(Ticket::getConvertible,Comparator.reverseOrder())
                .thenComparing(Ticket::getIsSpike,Comparator.reverseOrder())
                .thenComparing(t->Integer.parseInt(t.getSaleNum()),Comparator.reverseOrder())
                .thenComparing(t->Double.valueOf(t.getExIntegral()),Comparator.reverseOrder())
                .thenComparing(t->Double.valueOf(t.getExMoney()),Comparator.reverseOrder())
                .thenComparing(Ticket::getExEndTime,Comparator.naturalOrder())
                .thenComparing(Ticket::getCreateDate,Comparator.reverseOrder())
        );

        //输出
        Ticket.printTickets(list);
    }
}
