package com.zzx.model;
/**
 * 房屋表
 */

import java.util.Date;

public class House {
    private Integer hid;
    private String haddress;
    private String hfloor;
    private Integer hroomNum;
    private String harea;
    private String hdir;
    private Integer hdeco;
    private Integer hair;
    private double hprice;
    private Integer hrentStatus;
    private String himage;
    private Date haddTime;
    private Date hupdateTime;

    /**
     * 有参构造
     * @param hid
     * @param haddress
     * @param hfloor
     * @param hroomNum
     * @param harea
     * @param hdir
     * @param hdeco
     * @param hair
     * @param hprice
     * @param hrentStatus
     * @param himage
     * @param haddTime
     * @param hupdateTime
     */
    public House(Integer hid, String haddress, String hfloor, Integer hroomNum, String harea, String hdir, Integer hdeco, Integer hair, double hprice, Integer hrentStatus, String himage, Date haddTime, Date hupdateTime) {
        this.hid = hid;
        this.haddress = haddress;
        this.hfloor = hfloor;
        this.hroomNum = hroomNum;
        this.harea = harea;
        this.hdir = hdir;
        this.hdeco = hdeco;
        this.hair = hair;
        this.hprice = hprice;
        this.hrentStatus = hrentStatus;
        this.himage = himage;
        this.haddTime = haddTime;
        this.hupdateTime = hupdateTime;
    }

    /**
     * 无参构造
     */
    public House() {
    }

    /**
     * setget方法
     * @return
     */
    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHfloor() {
        return hfloor;
    }

    public void setHfloor(String hfloor) {
        this.hfloor = hfloor;
    }

    public Integer getHroomNum() {
        return hroomNum;
    }

    public void setHroomNum(Integer hroomNum) {
        this.hroomNum = hroomNum;
    }

    public String getHarea() {
        return harea;
    }

    public void setHarea(String harea) {
        this.harea = harea;
    }

    public String getHdir() {
        return hdir;
    }

    public void setHdir(String hdir) {
        this.hdir = hdir;
    }

    public Integer getHdeco() {
        return hdeco;
    }

    public void setHdeco(Integer hdeco) {
        this.hdeco = hdeco;
    }

    public Integer getHair() {
        return hair;
    }

    public void setHair(Integer hair) {
        this.hair = hair;
    }

    public double getHprice() {
        return hprice;
    }

    public void setHprice(double hprice) {
        this.hprice = hprice;
    }

    public Integer getHrentStatus() {
        return hrentStatus;
    }

    public void setHrentStatus(Integer hrentStatus) {
        this.hrentStatus = hrentStatus;
    }

    public String getHimage() {
        return himage;
    }

    public void setHimage(String himage) {
        this.himage = himage;
    }

    public Date getHaddTime() {
        return haddTime;
    }

    public void setHaddTime(Date haddTime) {
        this.haddTime = haddTime;
    }

    public Date getHupdateTime() {
        return hupdateTime;
    }

    public void setHupdateTime(Date hupdateTime) {
        this.hupdateTime = hupdateTime;
    }

    /**
     * toString方法
     * @return
     */
    @Override
    public String toString() {
        return "house{" +
                "hid=" + hid +
                ", haddress='" + haddress + '\'' +
                ", hfloor='" + hfloor + '\'' +
                ", hroomNum=" + hroomNum +
                ", harea='" + harea + '\'' +
                ", hdir='" + hdir + '\'' +
                ", hdeco=" + hdeco +
                ", hair=" + hair +
                ", hprice=" + hprice +
                ", hrentStatus=" + hrentStatus +
                ", himage='" + himage + '\'' +
                ", haddTime=" + haddTime +
                ", hupdateTime=" + hupdateTime +
                '}';
    }
}
