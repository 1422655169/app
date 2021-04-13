package com.zzx.test;

import com.zzx.model.User;

public class TestReFlect {
    public static void main(String[] args) throws Exception{
        //获得字节码文件,全路径/权限命名
        Class clazz= Class.forName("com.zzx.model.User");

        Class clazz1= User.class;
        Class clazz1s = int.class;
        Class clazz2s = void.class;

        User user = new User();
        Class clazz2 = user.getClass();

        int[] arr = new int[5];
        Class clazz3 = arr.getClass();
    }
}
