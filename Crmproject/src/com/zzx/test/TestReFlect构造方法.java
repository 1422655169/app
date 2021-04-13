package com.zzx.test;
import java.lang.reflect.Constructor;

public class TestReFlect构造方法 {
    public static void main(String[] args) throws Exception{
        Class<kk> clazz = kk.class;
        Constructor<kk> constructor = clazz.getDeclaredConstructor();
        kk kk = constructor.newInstance();
        System.out.println(kk);
    }
}
