package com.example.listdemo.utils;

import com.example.listdemo.entity.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * List集合合并：合并两个list<Ticket>.list1合并到list2(list1的个数 > list2的个数)
 * @author qzz
 */
public class ListMerge3 {

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

        List<Ticket> list2 = new ArrayList<>();
        data=new Ticket();
        data.setTicketId("100001");
        data.setBatchId("1");
        list2.add(data);

        data=new Ticket();
        data.setTicketId("100001");
        data.setBatchId("2");
        list2.add(data);

//        data=new Ticket();
//        data.setTicketId("100002");
//        data.setBatchId("1");
//        list2.add(data);
//
//        data=new Ticket();
//        data.setTicketId("100002");
//        data.setBatchId("2");
//        list2.add(data);
//
//        data=new Ticket();
//        data.setTicketId("100002");
//        data.setBatchId("3");
//        list2.add(data);

        //使用stream流把list1合并到list2集合中，根据ticketId属性
        List<Ticket> list = list2.stream().map(m -> {
            list1.stream().filter(m2-> Objects.equals(m.getTicketId(),m2.getTicketId())).forEach(m2-> {
                m.setTicketId(m2.getTicketId());
                m.setTicketName(m2.getTicketName());
            });
            return m;
        }).collect(Collectors.toList());

        for(Ticket ticket:list){
            System.out.println(ticket.getTicketId()+","+ticket.getTicketName()+","+ticket.getBatchId());
        }
        return list;
    }
}
