package com.zzx.model;

import java.util.Date;

/**
 * 角色表
 */
public class Role {
    private Integer roid;
    private String roname;
    private String rodesc;
    private Date roaddTime;

    /**
     * 这里是有参构造
     * @param roid
     * @param roname
     * @param rodesc
     * @param roaddTime
     */
    public Role(Integer roid, String roname, String rodesc, Date roaddTime) {
        this.roid = roid;
        this.roname = roname;
        this.rodesc = rodesc;
        this.roaddTime = roaddTime;
    }

    /**
     * 这里是无参构造
     */
    public Role() {
    }

    /**
     * 这里是Set Get方法
     * @return
     */
    public Integer getRoid() {
        return roid;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public String getRoname() {
        return roname;
    }

    public void setRoname(String roname) {
        this.roname = roname;
    }

    public String getRodesc() {
        return rodesc;
    }

    public void setRodesc(String rodesc) {
        this.rodesc = rodesc;
    }

    public Date getRoaddTime() {
        return roaddTime;
    }

    public void setRoaddTime(Date roaddTime) {
        this.roaddTime = roaddTime;
    }

    /**
     * 这里是toString
     * @return
     */
    @Override
    public String toString() {
        return "role{" +
                "roid=" + roid +
                ", roname='" + roname + '\'' +
                ", rodesc='" + rodesc + '\'' +
                ", roaddTime=" + roaddTime +
                '}';
    }
}
