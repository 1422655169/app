package com.zzx.dao;

import com.zzx.model.Logi;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface LogiDao {
    ArrayList<Logi> SelectAll(PageUtil pageUtil);
    int count(String keyword);
    void findLogiByDelete(int loid);
    void findLogiByAdd(Logi logi);
    Logi findLogiById(int loid);
    void findLogiByUpdate(Logi logi);

    List<Logi> findAll(PageUtil pageUtil, HashMap<String, String> map);

    int count(HashMap<String, String> map);
}
