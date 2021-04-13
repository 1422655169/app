package com.zzx.model;

public class MxBean {
	
	/* `xh` int(255) NOT NULL default '0' COMMENT '序号',
	  `jyrq` varchar(255) default NULL COMMENT '交易日期',
	  `yelx` varchar(255) default NULL COMMENT '业务类型',
	  
	  `bz` varchar(255) default NULL COMMENT '币种',
	  `crje` varchar(255) default NULL COMMENT '存入金额',
	  `zqje` varchar(255) default NULL COMMENT '支取金额',
	  
	  `zhye` varchar(255) default NULL COMMENT '账户余额',
	  `dfzh` varchar(255) default NULL COMMENT '对方账号',
	  `dfxm` varchar(255) default NULL COMMENT '对付姓名',
	  
	  `dfkhh` varchar(255) default NULL COMMENT '对方开户行',
	  `fy` varchar(255) default NULL COMMENT '附言',
	  `zy` varchar(255) default NULL COMMENT '摘要',*/
	
	
	private String xh;
	private String jyrq;
	private String yelx;
	
	private String bz;
	private String crje;
	private String zqje;
	
	private String zhye;
	private String dfzh;
	private String dfxm;
	
	private String dfkhh;
	private String fy;
	private String zy;
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getJyrq() {
		return jyrq;
	}
	public void setJyrq(String jyrq) {
		this.jyrq = jyrq;
	}
	public String getYelx() {
		return yelx;
	}
	public void setYelx(String yelx) {
		this.yelx = yelx;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getCrje() {
		return crje;
	}
	public void setCrje(String crje) {
		this.crje = crje;
	}
	public String getZqje() {
		return zqje;
	}
	public void setZqje(String zqje) {
		this.zqje = zqje;
	}
	public String getZhye() {
		return zhye;
	}
	public void setZhye(String zhye) {
		this.zhye = zhye;
	}
	public String getDfzh() {
		return dfzh;
	}
	public void setDfzh(String dfzh) {
		this.dfzh = dfzh;
	}
	public String getDfxm() {
		return dfxm;
	}
	public void setDfxm(String dfxm) {
		this.dfxm = dfxm;
	}
	public String getDfkhh() {
		return dfkhh;
	}
	public void setDfkhh(String dfkhh) {
		this.dfkhh = dfkhh;
	}
	public String getFy() {
		return fy;
	}
	public void setFy(String fy) {
		this.fy = fy;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	@Override
	public String toString() {
		return "MxBean [xh=" + xh + ", jyrq=" + jyrq + ", yelx=" + yelx
				+ ", bz=" + bz + ", crje=" + crje + ", zqje=" + zqje
				+ ", zhye=" + zhye + ", dfzh=" + dfzh + ", dfxm=" + dfxm
				+ ", dfkhh=" + dfkhh + ", fy=" + fy + ", zy=" + zy + "]";
	}
	
	
}
