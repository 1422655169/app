package com.zzx.service;

import com.zzx.dao.RoleDao;
import com.zzx.model.Role;
import com.zzx.util.PageUtil;

import java.util.ArrayList;

public class RoleService {

    private RoleDao roleDao = new RoleDao();

    /**
     * 这里是查询所有
     * @param pageUtil
     * @return
     */
    public ArrayList<Role> SelectAll(PageUtil pageUtil){
        return roleDao.SelectAll(pageUtil);
    }

    /**
     * 这里是记录条数
     * @param keyword
     * @return
     */
    public int count(String keyword){
        return roleDao.count(keyword);
    }

    public void findRoleByAdd(Role role) {
        roleDao.findRoleByAdd(role);
    }

    public void findRoleByDelete(int roid) {
        roleDao.findRoleByDelete(roid);
    }

    public Role findRoleById(int roid) {
        return roleDao.findRoleById(roid);
    }

    public void findRoleByUpdate(Role role) {
        roleDao.findRoleByUpdate(role);
    }

}
