package com.zzx.test;

import com.zzx.model.User;

import javax.xml.transform.Source;
import java.lang.reflect.Field;

public class TestReFlect赋值 {
    public static void main(String[] args) throws Exception{
       User user = new User();
       user.setUname("张三");
       Class clazz = user.getClass();

        Field uname = clazz.getDeclaredField("uname");

        //获得属性名
        String name = uname.getName();
        System.out.println(name);

        //如果是私有属性,无法操作,设置为true即可
        uname.setAccessible(true);

        //获得属性值,(需要指定对象,即获得那个对象的该属性值)
        String s = (String) uname.get(user);

        //设置属性,参数1:哪个对象 参数2:属性值
        uname.set(user,"李四");
        String s2 = (String)uname.get(user);

        System.out.println(s2);
        System.out.println(s);
    }
}
