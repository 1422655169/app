package com.zzx.service;

import com.zzx.dao.HouseDao;
import com.zzx.model.House;
import com.zzx.model.User;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface HouseService {
    void addOne(House house);
    void DeleteOne(int id);
    House findHouseById(int hid);
    void findUpdateHouseById(House house);



    //新写的查询全部.模糊查询,分页
    List<House> findAll(PageUtil pageUtil, HashMap<String,String> keywordMap);
    int count(HashMap<String,String> keywordMap);

}
