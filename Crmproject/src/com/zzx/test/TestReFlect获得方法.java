package com.zzx.test;

import com.zzx.model.User;

import java.lang.reflect.Method;

public class TestReFlect获得方法 {
    public static void main(String[] args) throws Exception {
        Class<kk> clazz = kk.class;
        Method getUid = clazz.getDeclaredMethod("setAid");
        Method getUid2 = clazz.getDeclaredMethod("setAid",int.class);
        Method getUid3 = clazz.getDeclaredMethod("setAid", int.class, String.class);
        //方法执行
        getUid2.invoke(new kk(),1);
        //getUid2.invoke(new kk(),"a");//因为为int类型,所以不能写string类型的数据
        getUid.invoke(new kk());
        getUid3.invoke(new kk(),1,"哈哈");
    }
}
