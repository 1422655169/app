package com.zzx.dao;
import com.zzx.model.Activity;
import com.zzx.model.Contract;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ActivityDao {
    void findActivityByAdd(Activity activity);
    void findActivityByDelete(int aid);
    Activity findActivityById(int aid);
    void findActivityByUpdate(Activity activity);



    List<Activity> findAll(PageUtil pageUtil, HashMap<String, String> map);
    int count(HashMap<String, String> map);
}
