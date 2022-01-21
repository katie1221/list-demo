package com.example.listdemo.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 电子券信息
 * @author qzz
 */
@Data
public class Ticket {

    private String groupId;
    private String mallid;
    private String ticketId;
    private String ticketName;
    private String batchId;
    private String convertible;
    private String gradeLimit;
    private String batchAvailableNum;
    private String saleNum;
    private String exIntegral;
    private String exMoney;
    private String isSoldOut;
    private String isSpike;
    private Date exEndTime;
    private Date createDate;

    /**
     * 输出打印信息
     * @param list
     */
    public static void printTickets(List<Ticket> list){
        System.out.println("[电子券名称]\t\t[isSoldOut]\t\t[convertible]\t\t[isSpike]\t\t[saleNum]\t\t[exIntegral]\t\t[exMoney]\t\t[exEndTime]\t\t[createDate]");
        System.out.println("-----------------------------------------------------------------------");
        list.forEach(u-> System.out.println(printValue(u)));
        System.out.println(" ");
    }

    /***
     * 输出list结果集
     * @param ticket
     * @return
     */
    public static String printValue(Ticket ticket){
        String str=String.format("%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s",
                ticket.ticketName,ticket.isSoldOut,ticket.convertible.toString(),ticket.isSpike.toString(),ticket.saleNum.toString(),
                ticket.exIntegral.toString(),ticket.exMoney.toString(),ticket.exEndTime.toString(),ticket.createDate.toString());
        return str;
    }
}
