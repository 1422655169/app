package com.zzx.service.impl;

import com.zzx.dao.LogiDao;
import com.zzx.dao.impl.LogiDaoImpl;
import com.zzx.model.Logi;
import com.zzx.service.LogiService;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogiServiceImpl implements LogiService {
    private LogiDao logiDao = new LogiDaoImpl();

    /**
     * 这里是查询所有
     * @param pageUtil
     * @return
     */
    public ArrayList<Logi> SelectAll(PageUtil pageUtil){
        return logiDao.SelectAll(pageUtil);
    }

    /**
     * 这里是记录条数
     * @param keyword
     * @return
     */
    public int count(String keyword){
        return logiDao.count(keyword);
    }

    /**
     * 这是删除功能
     * @param loid
     */
    public void findLogiByDelete(int loid) {
        logiDao.findLogiByDelete(loid);
    }

    /**
     * 这是添加共能
     * @param logi
     */
    public void findLogiByAdd(Logi logi) {
        logiDao.findLogiByAdd(logi);
    }

    /**
     * 修改(作用:回显)
     * @param loid
     * @return
     */
    public Logi findLogiById(int loid) {
        return logiDao.findLogiById(loid);
    }

    /**
     * 修改(作用:修改数据)
     * @param logi
     */
    public void findLogiByUpdate(Logi logi) {
        logiDao.findLogiByUpdate(logi);
    }

    @Override
    public int count(HashMap<String, String> map) {
        return logiDao.count(map);
    }

    @Override
    public List<Logi> findAll(PageUtil pageUtil, HashMap<String, String> map) {
        return logiDao.findAll(pageUtil,map);
    }
}
