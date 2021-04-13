package com.zzx.util;
/**
 * 分页工具类
 */
public class PageUtil {

    private int pageNo; // 当前页
    private int pageSize = 5; // 每页多少条
    private int pageCount; // 总页数
    private int total; // 总条数
    private int start; // limit start
    private int end; // limit start,end

    public PageUtil(int pageNo,int total) {
        this.pageNo = pageNo;
        this.total = total;
        this.pageCount = total%pageSize==0?(total/pageSize):(total/pageSize)+1;
        this.start = (pageNo -1)*pageSize;
        this.end = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

