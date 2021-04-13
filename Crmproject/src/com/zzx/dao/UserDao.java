package com.zzx.dao;

import com.zzx.model.Auth;
import com.zzx.model.User;
import com.zzx.util.PageUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface UserDao {
    //登录
    User Login(String username, String password);
    //注册
    void SignIn(User user);
    //计算页数
    int count(HashMap<String, String> keywordMap);
    //查询全部
    ArrayList<User> SelectAll(PageUtil pageUtil);
    //根据id删除
    void findDeleteById(int id);
    //修改(先找到id)
    User findUpdateById(int uid);
    //修改数据
    void findUpdateByAll(User user);
    List<User> findRole(List<User> users);

    //权限
    List<Auth> findUserAuth(User user);

    List<User> findAll(PageUtil pageUtil, HashMap<String, String> keywordMap);
}
