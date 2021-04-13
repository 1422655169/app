package com.zzx.service.impl;

import com.zzx.dao.LesseeDao;
import com.zzx.dao.UserDao;
import com.zzx.dao.impl.LesseeDaoImpl;
import com.zzx.model.Lessee;
import com.zzx.service.LesseeService;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class LesseeServiceImpl implements LesseeService {
    private LesseeDao lesseeDao = new LesseeDaoImpl();

    /**
     * 这里是查询所有
     * @param pageUtil
     * @return
     */
    @Override
    public ArrayList<Lessee> SelectAll(PageUtil pageUtil, HashMap<String, String> keywordMap) {
        return lesseeDao.SelectAll(pageUtil,keywordMap);
    }
    /**
     * 这里是记录条数
     * @param keywordMap
     * @return
     */
    @Override
    public int count(HashMap<String, String> keywordMap) {
        return lesseeDao.count(keywordMap);
    }

    /**
     * 这里是删除单条数据
     * @param id
     */
    public void DeleteOne(int id){lesseeDao.DeleteOne(id);
        System.out.println("Lessee的Service层执行了");}

    /**
     * 添加单条数据
     * @param lessee
     */
    public void AddOne(Lessee lessee){
        lesseeDao.AddOne(lessee);
    }


    /**
     * 修改功能
     * @param
     * @return
     */
    public Lessee findContractById(int hid) {
        return lesseeDao.findContractById(hid);
    }

    public void findUpdateById(Lessee lessee) {
        lesseeDao.findUpdateById(lessee);
    }
}
