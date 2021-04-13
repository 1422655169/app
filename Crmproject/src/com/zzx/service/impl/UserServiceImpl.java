package com.zzx.service.impl;

import com.zzx.dao.UserDao;
import com.zzx.dao.impl.UserDaoImpl;
import com.zzx.model.Auth;
import com.zzx.model.User;
import com.zzx.service.UserService;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new
            UserDaoImpl();

    /**
     * 这里是登录功能
     * @param username
     * @param password
     * @return
     */
    public User logins(String username, String password){
        //在调用dao层之前,做出一些处理
        User user = userDao.Login(username,password);
        // 在返回前,做出一些处理
        return user;
    }

    /**
     * 这里是注册
     * @param user
     */
    public void SignIn(User user){
        userDao.SignIn(user);
    }

    /**
     * 这里是查询所有
     * @param pageUtil
     * @return
     */
    public ArrayList<User> SelectAll(PageUtil pageUtil){
        return userDao.SelectAll(pageUtil);
    }

    @Override
    public List<User> findAll(PageUtil pageUtil, HashMap<String, String> keywordMap) {
        List<User> houseList = userDao.findAll(pageUtil,keywordMap);
        return houseList;
    }

    @Override
    public int count(HashMap<String, String> keywordMap) {
        int total = userDao.count(keywordMap);
        return total;
    }


    public void findDeleteById(int id) {
        userDao.findDeleteById(id);
    }

    public User findUpdateById(int uid) {
        return userDao.findUpdateById(uid);
    }

    public void findUpdateByAll(User user) {
        userDao.findUpdateByAll(user);
    }

    @Override
    public List<User> findRole(List<User> users) {
        return userDao.findRole(users);
    }

    @Override
    public List<Auth> findUserAuth(User user) {
        return userDao.findUserAuth(user);
    }


}
