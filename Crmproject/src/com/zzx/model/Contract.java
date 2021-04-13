package com.zzx.model;

import java.util.Date;

/**
 * 租贷合同表
 */
public class Contract {
    private Integer cid;
    private String cnum;
    private Integer chid;
    private Integer clid;
    private Date ctime;
    private Date cstartTime;
    private Date cendTime;
    private String ctotalMoney;
    private Integer cpayType;

    //一对一
    private House house;
    private Lessee lessee;





    /**
     * 有参构造
     * 此表的chid列对应house表中的hid列
     * 此表的clid列对应lessee表中的lid列
     * @param cid
     * @param cnum
     * @param chid
     * @param clid
     * @param ctime
     * @param cstartTime
     * @param cendTime
     * @param ctotalMoney
     * @param cpayType
     */
    public Contract(Integer cid, String cnum, Integer chid, Integer clid, Date ctime, Date cstartTime, Date cendTime, String ctotalMoney, Integer cpayType, House house, Lessee lessee) {
        this.cid = cid;
        this.cnum = cnum;
        this.chid = chid;
        this.clid = clid;
        this.ctime = ctime;
        this.cstartTime = cstartTime;
        this.cendTime = cendTime;
        this.ctotalMoney = ctotalMoney;
        this.cpayType = cpayType;
        this.house = house;
        this.lessee = lessee;
    }

    /**
     * 无参构造
     */
    public Contract() {
    }

    /**
     * Set Get 方法
     * @return
     */
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getCstartTime() {
        return cstartTime;
    }

    public void setCstartTime(Date cstartTime) {
        this.cstartTime = cstartTime;
    }

    public Date getCendTime() {
        return cendTime;
    }

    public void setCendTime(Date cendTime) {
        this.cendTime = cendTime;
    }

    public String getCtotalMoney() {
        return ctotalMoney;
    }

    public void setCtotalMoney(String ctotalMoney) {
        this.ctotalMoney = ctotalMoney;
    }

    public Integer getCpayType() {
        return cpayType;
    }

    public void setCpayType(Integer cpayType) {
        this.cpayType = cpayType;
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
     * toString 方法
     * @return
     */
    @Override
    public String toString() {
        return "Contract{" +
                "cid=" + cid +
                ", cnum='" + cnum + '\'' +
                ", chid=" + chid +
                ", clid=" + clid +
                ", ctime=" + ctime +
                ", cstartTime=" + cstartTime +
                ", cendTime=" + cendTime +
                ", ctotalMoney='" + ctotalMoney + '\'' +
                ", cpayType=" + cpayType +
                ", house=" + house +
                ", lessee=" + lessee +
                '}';
    }
}
