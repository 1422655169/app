package com.zzx.service;

import com.zzx.dao.ActivityDao;
import com.zzx.model.Activity;
import com.zzx.model.Contract;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ActivityService {
    void findActivityByAdd(Activity activity);
    void findActivityByDelete(int aid);
    Activity findActivityById(int aid);
    void findActivityByUpdate(Activity activity);


    int count(HashMap<String, String> map);
    List<Activity> findAll(PageUtil pageUtil, HashMap<String, String> map);
}
