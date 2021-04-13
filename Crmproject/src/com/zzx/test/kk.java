package com.zzx.test;
@xuan(a=1,arr={"a","a","b"})
public class kk {
    //@xuan(arr={"a","a","b"})
    private int aid;
    private String adesc;

    @Override
    public String toString() {
        return "kk{" +
                "aid=" + aid +
                ", adesc='" + adesc + '\'' +
                '}';
    }

    public kk() {
    }

    public kk(int aid, String adesc) {
        this.aid = aid;
        this.adesc = adesc;
    }

    public int getAid() {
        return aid;
    }

    public String getAdesc() {
        return adesc;
    }

    public void setAdesc(String adesc) {
        this.adesc = adesc;
    }

    public void setAid() {
        System.out.println("set空");
    }

    public void setAid(int aid) {
        System.out.println("set的Int");
    }

    public void setAid(int aid,String ss) {
        System.out.println("set的Int,以及string");
    }

}
