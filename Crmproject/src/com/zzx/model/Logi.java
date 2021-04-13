package com.zzx.model;

import java.util.Date;

/**
 * 后勤人员管理表
 */
public class Logi {
    private Integer loid;
    private String loname;
    private String loidCard;
    private String lotel;
    private Integer losex;      // 这里的1代表男,2代表女
    private Date loaddTime;
    private double losalary;

    /**
     * 有参构造
     * @param loid
     * @param loname
     * @param loidCard
     * @param lotel
     * @param losex
     * @param loaddTime
     * @param losalary
     */
    public Logi(Integer loid, String loname, String loidCard, String lotel, Integer losex, Date loaddTime, double losalary) {
        this.loid = loid;
        this.loname = loname;
        this.loidCard = loidCard;
        this.lotel = lotel;
        this.losex = losex;
        this.loaddTime = loaddTime;
        this.losalary = losalary;
    }

    /**
     * 无参构造
     */
    public Logi() {
    }


    /**
     * Set Get 方法
     * @return
     */
    public Integer getLoid() {
        return loid;
    }

    public void setLoid(Integer loid) {
        this.loid = loid;
    }

    public String getLoname() {
        return loname;
    }

    public void setLoname(String loname) {
        this.loname = loname;
    }

    public String getLoidCard() {
        return loidCard;
    }

    public void setLoidCard(String loidCard) {
        this.loidCard = loidCard;
    }

    public String getLotel() {
        return lotel;
    }

    public void setLotel(String lotel) {
        this.lotel = lotel;
    }

    public Integer getLosex() {
        return losex;
    }

    public void setLosex(Integer losex) {
        this.losex = losex;
    }

    public Date getLoaddTime() {
        return loaddTime;
    }

    public void setLoaddTime(Date loaddTime) {
        this.loaddTime = loaddTime;
    }

    public double getLosalary() {
        return losalary;
    }

    public void setLosalary(double losalary) {
        this.losalary = losalary;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "logi{" +
                "loid=" + loid +
                ", loname='" + loname + '\'' +
                ", loidCard='" + loidCard + '\'' +
                ", lotel='" + lotel + '\'' +
                ", losex=" + losex +
                ", loaddTime=" + loaddTime +
                ", losalary=" + losalary +
                '}';
    }
}
