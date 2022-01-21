package com.example.listdemo.utils;

import com.example.listdemo.entity.Ticket;

import java.util.*;
import java.util.stream.Collectors;

/**
 * List集合合并：合并两个list<Ticket>,并将ticketId相同的其它属性合并
 * @author qzz
 */
public class ListMerge1 {

    public static void main(String[] args) {
        mergeList();
    }
    /**
     * @Description: 合并两个list<Ticket>,并将ticketId相同的其它属性合并
     * @Title: mergeList
     * @param: @return
     * @return: List<Ticket>
     * @throws
     */
    public static List<Ticket> mergeList(){
        List<Ticket> list1 = new ArrayList<>();
        Ticket data=new Ticket();
        data.setTicketId("100001");
        data.setTicketName("唐僧");
        list1.add(data);

        data=new Ticket();
        data.setTicketId("100002");
        data.setTicketName("八戒");
        list1.add(data);

        data=new Ticket();
        data.setTicketId("100003");
        data.setTicketName("悟空");
        list1.add(data);

        data=new Ticket();
        data.setTicketId("100004");
        data.setTicketName("沙僧");
        list1.add(data);


        List<Ticket> list2 = new ArrayList<>();
        data=new Ticket();
        data.setTicketId("100001");
        data.setSaleNum("20");
        data.setBatchAvailableNum("10");
        list2.add(data);

        data=new Ticket();
        data.setTicketId("100001");
        data.setSaleNum("20");
        data.setBatchAvailableNum("10");
        list2.add(data);

        data=new Ticket();
        data.setTicketId("100002");
        data.setSaleNum("1000");
        data.setBatchAvailableNum("600");
        list2.add(data);

        data=new Ticket();
        data.setTicketId("100003");
        data.setSaleNum("600");
        data.setBatchAvailableNum("100");
        list2.add(data);

        data=new Ticket();
        data.setTicketId("100004");
        data.setSaleNum("800");
        data.setBatchAvailableNum("300");
        list2.add(data);

        //使用stream流把list1和list2根据属性ticketId合并一个list集合
        List<Ticket> list = list1.stream().map(m -> {
            list2.stream().filter(m2-> Objects.equals(m.getTicketId(),m2.getTicketId())).forEach(m2-> {
                m.setSaleNum(m2.getSaleNum());
                m.setBatchAvailableNum(m2.getBatchAvailableNum());
            });
            return m;
        }).collect(Collectors.toList());

        for(Ticket ticket:list){
            System.out.println(ticket.getTicketId()+","+ticket.getTicketName()+","+ticket.getSaleNum()+","+ticket.getBatchAvailableNum());
        }
        return list;
    }
}
