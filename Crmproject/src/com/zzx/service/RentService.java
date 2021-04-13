package com.zzx.service;

import com.sun.org.apache.regexp.internal.RE;
import com.zzx.dao.RentDao;
import com.zzx.dao.impl.RentDaoImpl;
import com.zzx.model.Lessee;
import com.zzx.model.Rent;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface RentService {
    void addone(Rent rent);
    void  deleteOne(int id);
    Rent findLesseeById(int hid);
    void findUpdateLesseeById(Rent rent);
    List<Rent> findAll(PageUtil pageUtil, HashMap<String, String> map);
    int count(HashMap<String, String> map);
}
