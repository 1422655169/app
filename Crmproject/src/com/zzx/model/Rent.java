package com.zzx.model;

import java.util.Date;

/**
 * 房租表
 */
public class Rent {
    private Integer rid;
    private Integer rhid;
    private Integer rlid;
    private double rprice;
    private Date rpayTime;
    private House house;
    private Lessee lessee;


    /**
     * 有参构造
     * 此表的rhid列对应house表中的hid列
     * 此表的rlid列对应lessee表中的lid列
     * @param rid
     * @param rhid
     * @param rlid
     * @param rprice
     * @param rpayTime
     */
    public Rent(Integer rid, Integer rhid, Integer rlid, double rprice, Date rpayTime) {
        this.rid = rid;
        this.rhid = rhid;
        this.rlid = rlid;
        this.rprice = rprice;
        this.rpayTime = rpayTime;
    }

    public Rent(Integer rid, Integer rhid, Integer rlid, double rprice, Date rpayTime, House house, Lessee lessee) {
        this.rid = rid;
        this.rhid = rhid;
        this.rlid = rlid;
        this.rprice = rprice;
        this.rpayTime = rpayTime;
        this.house = house;
        this.lessee = lessee;
    }

    /**
     * 无参构造
     */
    public Rent() {
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Lessee getLessee() {
        return lessee;
    }

    public void setLessee(Lessee lessee) {
        this.lessee = lessee;
    }

    /**
     * Set Get方法
     * @return
     */
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRhid() {
        return rhid;
    }

    public void setRhid(Integer rhid) {
        this.rhid = rhid;
    }

    public Integer getRlid() {
        return rlid;
    }

    public void setRlid(Integer rlid) {
        this.rlid = rlid;
    }

    public double getRprice() {
        return rprice;
    }

    public void setRprice(double rprice) {
        this.rprice = rprice;
    }

    public Date getRpayTime() {
        return rpayTime;
    }

    public void setRpayTime(Date rpayTime) {
        this.rpayTime = rpayTime;
    }

    /**
     * toString方法
     *
     * @return
     */
    @Override
    public String toString() {
        return "Rent{" +
                "rid=" + rid +
                ", rhid=" + rhid +
                ", rlid=" + rlid +
                ", rprice=" + rprice +
                ", rpayTime=" + rpayTime +
                ", house=" + house +
                ", lessee=" + lessee +
                '}';
    }
}
