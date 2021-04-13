package com.zzx.dao;

import com.zzx.model.Lessee;
import com.zzx.util.PageUtil;
import java.util.ArrayList;
import java.util.HashMap;

public interface LesseeDao {
    ArrayList<Lessee> SelectAll(PageUtil pageUtil, HashMap<String, String> keywordMap);
    int count(HashMap<String, String> keywordMap);
    void DeleteOne(int id);
    void AddOne(Lessee lessee);
    Lessee findContractById(int id);
    void findUpdateById(Lessee lessee);
}
