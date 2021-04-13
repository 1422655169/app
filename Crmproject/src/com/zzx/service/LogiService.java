package com.zzx.service;

import com.zzx.dao.LogiDao;
import com.zzx.dao.impl.LogiDaoImpl;
import com.zzx.model.Lessee;
import com.zzx.model.Logi;
import com.zzx.util.PageUtil;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface LogiService {
//    ArrayList<Logi> SelectAll(PageUtil pageUtil);
//    int count(String keyword);
    void findLogiByDelete(int loid);
    void findLogiByAdd(Logi logi);
    Logi findLogiById(int loid);
    void findLogiByUpdate(Logi logi);

    int count(HashMap<String, String> map);

    List<Logi> findAll(PageUtil pageUtil, HashMap<String, String> map);
}
