package com.example.listdemo.utils;

import com.example.listdemo.entity.Ticket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * List集合排序：单字段排序
 * @author qzz
 */
public class ListSort {

    public static void main(String[] args) {
        List<Ticket> list = new ArrayList<Ticket>();
        Ticket data = new Ticket();
        data.setGroupId("8a8480487c96d58f017c9b7bab7d0020");
        data.setMallid("8a8481f57cca9442017ce026ddd40049");
        data.setTicketId("1b82899c065d4474b85cfb809a99396a");
        data.setTicketName("金卡");
        data.setBatchId("7ed298bd08104cfe9ece16621c5e51ce");
        data.setConvertible("0");
        data.setGradeLimit("金卡");
        data.setBatchAvailableNum("100");
        data.setSaleNum("10");
        list.add(data);

        data = new Ticket();
        data.setGroupId("8a8480487c96d58f017c9b7bab7d0020");
        data.setMallid("8a8481f57cca9442017ce026ddd40049");
        data.setTicketId("5ecd6634026c45edaca8b4ebfdf3964c");
        data.setTicketName("电子券001");
        data.setBatchId("2d29984f938b446b9174a24233b64b39");
        data.setConvertible("1");
        data.setGradeLimit("都可");
        data.setBatchAvailableNum("100");
        data.setSaleNum("30");
        list.add(data);

        data = new Ticket();
        data.setGroupId("8a8480487c96d58f017c9b7bab7d0020");
        data.setMallid("8a8481f57cca9442017ce026ddd40049");
        data.setTicketId("5ecd6634026c45edaca8b4ebfdf3964c");
        data.setTicketName("电子券001");
        data.setBatchId("2d29984f938b446b9174a24233b64b39");
        data.setConvertible("0");
        data.setGradeLimit("都可");
        data.setBatchAvailableNum("100");
        data.setSaleNum("3");
        list.add(data);

        data = new Ticket();
        data.setGroupId("8a8480487c96d58f017c9b7bab7d0020");
        data.setMallid("8a8481f57cca9442017ce026ddd40049");
        data.setTicketId("5ecd6634026c45edaca8b4ebfdf3964c");
        data.setTicketName("电子券001");
        data.setBatchId("2d29984f938b446b9174a24233b64b39");
        data.setConvertible("0");
        data.setGradeLimit("都可");
        data.setBatchAvailableNum("100");
        data.setSaleNum("6");
        list.add(data);

        data = new Ticket();
        data.setGroupId("8a8480487c96d58f017c9b7bab7d0020");
        data.setMallid("8a8481f57cca9442017ce026ddd40049");
        data.setTicketId("5ecd6634026c45edaca8b4ebfdf3964c");
        data.setTicketName("电子券001");
        data.setBatchId("2d29984f938b446b9174a24233b64b39");
        data.setConvertible("0");
        data.setGradeLimit("都可");
        data.setBatchAvailableNum("100");
        data.setSaleNum("11");
        list.add(data);

        data = new Ticket();
        data.setGroupId("8a8480487c96d58f017c9b7bab7d0020");
        data.setMallid("8a8481f57cca9442017ce026ddd40049");
        data.setTicketId("96c166ce59894cf0a4f8fc14a5c94fb2");
        data.setTicketName("普卡");
        data.setBatchId("1c332332b0d64d729a3521ea253fe621");
        data.setConvertible("1");
        data.setGradeLimit("普卡");
        data.setBatchAvailableNum("90");
        data.setSaleNum("33");
        list.add(data);

        data = new Ticket();
        data.setGroupId("8a8480487c96d58f017c9b7bab7d0020");
        data.setMallid("8a8481f57cca9442017ce026ddd40049");
        data.setTicketId("b3826676e6e14168b58a1342b049723c");
        data.setTicketName("银卡");
        data.setBatchId("6d32889f9ab7450fb48fedad5efcaf85");
        data.setConvertible("0");
        data.setGradeLimit("银卡");
        data.setBatchAvailableNum("30");
        data.setSaleNum("33");
        list.add(data);
        //根据ticketId字段进行分组
        Map<String, List<Ticket>> map = list.stream().collect(Collectors.groupingBy(Ticket::getTicketId));
        List<Ticket> newList = new ArrayList<Ticket>();
        //取每组的第一条数据
        map.forEach((s, tickets) -> {
            newList.add(tickets.get(0));
        });

        for(Ticket ticket:newList){
            System.out.println(ticket.getTicketName()+","+ticket.getConvertible()+","+ticket.getSaleNum()+","+ticket.getBatchAvailableNum());
        }
        System.out.println("--------------------------------------list------------------------------------");
        // 根据SaleNum降序
        newList.sort(Comparator.comparing(Ticket::getSaleNum).reversed());
       //BatchAvailableNum降序
        newList.sort(Comparator.comparing(Ticket::getBatchAvailableNum).reversed());

        for(Ticket ticket:newList){
            System.out.println("ticketName："+ticket.getTicketName()+",convertible："+ticket.getConvertible()+",saleNum："+ticket.getSaleNum()+",batchAvailableNum："+ticket.getBatchAvailableNum());
        }
    }
}
