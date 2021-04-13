package com.zzx.model;
/**
 * 系统用户表
 */
import java.util.Date;
import java.util.List;

public class User {
    private Integer uid;
    private String uname;
    private String upassword;
    private String urealname;
    private Date uaddTime;
    private Integer ustatus;
    //一对多.在一的一方的实体类中设置集合用来存储多的一方的数据
    private List<Role> roles;

    public User() {
    }

    public User(Integer uid, String uname, String upassword, String urealname, Date uaddTime, Integer ustatus, List<Role> roles) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.urealname = urealname;
        this.uaddTime = uaddTime;
        this.ustatus = ustatus;
        this.roles = roles;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUrealname() {
        return urealname;
    }

    public void setUrealname(String urealname) {
        this.urealname = urealname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Date getUaddTime() {
        return uaddTime;
    }

    public void setUaddTime(Date uaddTime) {
        this.uaddTime = uaddTime;
    }

    public Integer getUstatus() {
        return ustatus;
    }

    public void setUstatus(Integer ustatus) {
        this.ustatus = ustatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", urealname='" + urealname + '\'' +
                ", uaddTime=" + uaddTime +
                ", ustatus=" + ustatus +
                ", roles=" + roles +
                '}';
    }
}
