package com.zzx.dao;

import com.sun.org.apache.regexp.internal.RE;
import com.zzx.model.House;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface HouseDao {
    void AddOne(House house);
    void DeleteOne(int id);
    House findHouseById(int hid);
    void findUpdateHouseById(House house);


    int count(HashMap<String, String> keywordMap);
    List<House> findAll(PageUtil pageUtil, HashMap<String, String> keywordMap);
}
