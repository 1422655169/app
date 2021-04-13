package com.zzx.service;

import com.zzx.dao.MaintainDao;
import com.zzx.model.Maintain;
import com.zzx.util.PageUtil;

import java.util.ArrayList;

public class MaintainService {

    private MaintainDao maintainDao = new MaintainDao();

    /**
     * 这里是查询所有
     * @param pageUtil
     * @return
     */
    public ArrayList<Maintain> SelectAll(PageUtil pageUtil){
        return maintainDao.SelectAll(pageUtil);
    }

    /**
     * 这里是记录条数
     * @param keyword
     * @return
     */
    public int count(String keyword){
        return maintainDao.count(keyword);
    }

    public void findMaintainByDelete(int mid) {
        maintainDao.findMaintainByDelete(mid);
    }

    public void findMaintainByAdd(Maintain maintain) {
        maintainDao.findMaintainByAdd(maintain);
    }

    public Maintain findMaintainById(int mid) {
        return maintainDao.findMaintainById(mid);
    }

    public void findMaintainByUpdate(Maintain maintain) {
        maintainDao.findMaintainByUpdate(maintain);
    }
}
