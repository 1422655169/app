package com.zzx.model;
/**
 * 租户表
 */
import java.util.Date;

public class Lessee {
    private Integer lid;
    private String lname;
    private String ltel;
    private Integer lsex;   //性别: 1代表男   2代表女
    private String lnp;
    private String lidCard;
    private Date laddTime;

    /**
     * 有参构造
     * @param lid
     * @param lname
     * @param ltel
     * @param lsex
     * @param lnp
     * @param lidCard
     * @param laddTime
     */
    public Lessee(Integer lid, String lname, String ltel, Integer lsex, String lnp, String lidCard, Date laddTime) {
        this.lid = lid;
        this.lname = lname;
        this.ltel = ltel;
        this.lsex = lsex;
        this.lnp = lnp;
        this.lidCard = lidCard;
        this.laddTime = laddTime;
    }

    /**
     * 无参构造
     */
    public Lessee() {
    }


    /**
     * Set Get 方法
     * @return
     */
    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLtel() {
        return ltel;
    }

    public void setLtel(String ltel) {
        this.ltel = ltel;
    }

    public Integer getLsex() {
        return lsex;
    }

    public void setLsex(Integer lsex) {
        this.lsex = lsex;
    }

    public String getLnp() {
        return lnp;
    }

    public void setLnp(String lnp) {
        this.lnp = lnp;
    }

    public String getLidCard() {
        return lidCard;
    }

    public void setLidCard(String lidCard) {
        this.lidCard = lidCard;
    }

    public Date getLaddTime() {
        return laddTime;
    }

    public void setLaddTime(Date laddTime) {
        this.laddTime = laddTime;
    }

    /**
     * toString方法
     * @return
     */
    @Override
    public String toString() {
        return "lessee{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", ltel='" + ltel + '\'' +
                ", lsex=" + lsex +
                ", lnp='" + lnp + '\'' +
                ", lidCard='" + lidCard + '\'' +
                ", laddTime=" + laddTime +
                '}';
    }
}
