package com.zzx.service.impl;

import com.zzx.dao.ActivityDao;
import com.zzx.dao.UserDao;
import com.zzx.dao.impl.ActivityDaoImpl;
import com.zzx.model.Activity;
import com.zzx.service.ActivityService;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = new ActivityDaoImpl();

    /**
     * 这里是查询所有
     * @param pageUtil
     * @return
     */
    @Override
    public List<Activity> findAll(PageUtil pageUtil, HashMap<String, String> map) {
        return activityDao.findAll(pageUtil,map);
    }
    /**
     * 这里是记录条数
     * @param
     * @return
     */
    @Override
    public int count(HashMap<String, String> map) {
        return activityDao.count(map);
    }

    public void findActivityByAdd(Activity activity) {
        activityDao.findActivityByAdd(activity);
    }

    public void findActivityByDelete(int aid) {
        activityDao.findActivityByDelete(aid);
    }

    public Activity findActivityById(int aid) {
        return activityDao.findActivityById(aid);
    }

    public void findActivityByUpdate(Activity activity) {
        activityDao.findActivityByUpdate(activity);
    }




}
