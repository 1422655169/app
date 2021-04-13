package com.zzx.model;

/**
 * 权限表
 */
public class Auth {
    private int aid;
    private String adesc;

    public Auth(int aid, String adesc) {
        this.aid = aid;
        this.adesc = adesc;
    }

    public Auth() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAdesc() {
        return adesc;
    }

    public void setAdesc(String adesc) {
        this.adesc = adesc;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "aid=" + aid +
                ", adesc='" + adesc + '\'' +
                '}';
    }
}





