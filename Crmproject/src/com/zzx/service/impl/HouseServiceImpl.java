package com.zzx.service.impl;

import com.zzx.dao.HouseDao;
import com.zzx.dao.impl.HouseDaoImpl;
import com.zzx.model.House;
import com.zzx.service.HouseService;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HouseServiceImpl implements HouseService {
    private HouseDao houseDao = new HouseDaoImpl();
    /**
     * 这里是添加单条数据
     * @param house
     */
    public void addOne(House house){ houseDao.AddOne(house); }

    /**
     * 这里是删除单条数据
     * @param id
     */
    public void DeleteOne(int id){houseDao.DeleteOne(id);}

    /**
     * 修改功能
     * @param
     * @return
     */
    public House findHouseById(int hid) {
        return houseDao.findHouseById(hid);
    }

    public void findUpdateHouseById(House house) {
        houseDao.findUpdateHouseById(house);
    }

    @Override
    public List<House> findAll(PageUtil pageUtil, HashMap<String, String> keywordMap) {
        List<House> list = houseDao.findAll(pageUtil,keywordMap);
        return list;
    }

    @Override
    public int count(HashMap<String, String> keywordMap) {
        int total = houseDao.count(keywordMap);
        return total;
    }


}
