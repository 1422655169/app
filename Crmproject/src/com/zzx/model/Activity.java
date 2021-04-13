package com.zzx.model;

import java.util.Date;

/**
 * 活动表
 */
public class Activity {
    private Integer aid;
    private Date atime;
    private String asubject;
    private String aintr;
    private String aaddress;
    private double aprice;

    /**
     * 这里是有参构造
     * @param aid
     * @param atime
     * @param asubject
     * @param aintr
     * @param aaddress
     * @param aprice
     */
    public Activity(Integer aid, Date atime, String asubject, String aintr, String aaddress, double aprice) {
        this.aid = aid;
        this.atime = atime;
        this.asubject = asubject;
        this.aintr = aintr;
        this.aaddress = aaddress;
        this.aprice = aprice;
    }

    /**
     * 这里是无参构造
     */
    public Activity() {
    }

    /**
     * 这里是Set Get方法
     * @return
     */
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getAtime() {
        return atime;
    }

    public void setAtime(Date atime) {
        this.atime = atime;
    }

    public String getAsubject() {
        return asubject;
    }

    public void setAsubject(String asubject) {
        this.asubject = asubject;
    }

    public String getAintr() {
        return aintr;
    }

    public void setAintr(String aintr) {
        this.aintr = aintr;
    }

    public String getAaddress() {
        return aaddress;
    }

    public void setAaddress(String aaddress) {
        this.aaddress = aaddress;
    }

    public double getAprice() {
        return aprice;
    }

    public void setAprice(double aprice) {
        this.aprice = aprice;
    }

    /**
     * 这里是toString方法
     * @return
     */
    @Override
    public String toString() {
        return "activity{" +
                "aid=" + aid +
                ", atime=" + atime +
                ", asubject='" + asubject + '\'' +
                ", aintr='" + aintr + '\'' +
                ", aaddress='" + aaddress + '\'' +
                ", aprice=" + aprice +
                '}';
    }
}
