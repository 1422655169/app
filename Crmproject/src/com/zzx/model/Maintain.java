package com.zzx.model;

import java.util.Date;

/**
 * 公寓修缮记录表
 */
public class Maintain {
    private Integer mid;
    private Integer mhid;
    private Integer mloid;
    private Date mtime;
    private String mresult;

    /**
     * 这是有参构造
     * 此表的mhid列是house表中的hid列
     * 此表的mloid列是logi表中的loid列
     * @param mid
     * @param mhid
     * @param mloid
     * @param mtime
     * @param mresult
     */
    public Maintain(Integer mid, Integer mhid, Integer mloid, Date mtime, String mresult) {
        this.mid = mid;
        this.mhid = mhid;
        this.mloid = mloid;
        this.mtime = mtime;
        this.mresult = mresult;
    }

    /**
     * 这是无参构造
     */
    public Maintain() {
    }

    /**
     * 这里是Set Get 方法
     * @return
     */
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getMhid() {
        return mhid;
    }

    public void setMhid(Integer mhid) {
        this.mhid = mhid;
    }

    public Integer getMloid() {
        return mloid;
    }

    public void setMloid(Integer mloid) {
        this.mloid = mloid;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getMresult() {
        return mresult;
    }

    public void setMresult(String mresult) {
        this.mresult = mresult;
    }

    /**
     * 这里是toString构造
     * @return
     */
    @Override
    public String toString() {
        return "maintain{" +
                "mid=" + mid +
                ", mhid=" + mhid +
                ", mloid=" + mloid +
                ", mtime=" + mtime +
                ", mresult='" + mresult + '\'' +
                '}';
    }
}
