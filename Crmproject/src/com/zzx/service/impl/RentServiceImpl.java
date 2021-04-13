package com.zzx.service.impl;

import com.zzx.dao.RentDao;
import com.zzx.dao.impl.RentDaoImpl;
import com.zzx.model.Rent;
import com.zzx.service.RentService;
import com.zzx.util.PageUtil;

import java.util.HashMap;
import java.util.List;

public class RentServiceImpl implements RentService {
    private RentDao rentDao = new RentDaoImpl();

    /**
     * 这里是添加
     * @param rent
     */
    public void addone(Rent rent){
        rentDao.AddOne(rent);
    }

    /**
     * 这里是删除单条数据
     * @param id
     */
    public void  deleteOne(int id){
        rentDao.DeleteOne(id);
    }
    /**
     * 修改功能
     * @param
     * @return
     */
    public Rent findLesseeById(int hid) {
        return rentDao.findRentById(hid);
    }

    public void findUpdateLesseeById(Rent rent) {
        rentDao.findUpdateById(rent);
    }

    public List<Rent> findAll(PageUtil pageUtil, HashMap<String, String> map) {
        return rentDao.findAll(pageUtil,map);
    }

    public int count(HashMap<String, String> map) {
        return rentDao.count(map);
    }
}
