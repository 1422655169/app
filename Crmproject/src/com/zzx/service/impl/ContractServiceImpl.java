package com.zzx.service.impl;

import com.zzx.dao.ContractDao;
import com.zzx.dao.impl.ContractDaoImpl;
import com.zzx.model.Contract;
import com.zzx.service.ContractService;
import com.zzx.util.PageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    private ContractDao contractDao = new ContractDaoImpl();
    /**
     * 这里是查询所有
     * @param pageUtil
     * @return
     */
    public ArrayList<Contract> SelectAll(PageUtil pageUtil){
        return contractDao.SelectAll(pageUtil);
    }

    /**
     * 这里是记录条数
     * @param keyword
     * @return
     */
    public int count(String keyword){
        return contractDao.count(keyword);
    }

    /**
     * 这里是添加单条数据
     * @param contract
     */
    public void AddOne(Contract contract){ contractDao.AddOne(contract); }

    /**
     * 这里是删除单条数据
     * @param id
     */
    public void DeleteOne(int id){contractDao.DeleteOne(id);}


    /**
     * 修改功能
     * @param
     * @return
     */
    public Contract findContractById(int cid) {
        return contractDao.findContractById(cid);
    }
    public void findUpdateById(Contract contract) {
        contractDao.findUpdateById(contract);
    }

    @Override
    public List<Contract> findAll(PageUtil pageUtil, HashMap<String, String> keywordMap) {
        List<Contract> list = contractDao.findAll(pageUtil,keywordMap);
        return list;
    }

    @Override
    public int count(HashMap<String, String> keywordMap) {
        int total = contractDao.count(keywordMap);
        return total;
    }


}
