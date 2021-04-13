package com.zzx.dao;

import com.zzx.model.Contract;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ContractDao {

    ArrayList<Contract> SelectAll(PageUtil pageUtil);
    //这里是获取数据条数的
    public int count(String keyword);
    //添加
    void AddOne(Contract act);
    //删除
    void DeleteOne(int id);
    //修改
    Contract findContractById(int cid);
    void findUpdateById(Contract contract);

    //新写的查询全部.模糊查询,分页
    List<Contract> findAll(PageUtil pageUtil, HashMap<String,String> keywordMap);
    int count(HashMap<String,String> keywordMap);


}
