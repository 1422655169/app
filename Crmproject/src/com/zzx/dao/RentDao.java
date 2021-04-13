package com.zzx.dao;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xml.internal.serializer.ToTextSAXHandler;
import com.zzx.model.Contract;
import com.zzx.model.Lessee;
import com.zzx.model.Rent;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *此处是房租信息表
 */
public interface RentDao {

    void AddOne(Rent rent);

    void DeleteOne(int id);

    Rent findRentById(int hid);

    void findUpdateById(Rent rent);

    List<Rent> findAll(PageUtil pageUtil, HashMap<String, String> map);

    int count(HashMap<String, String> map);
}
