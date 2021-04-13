package com.zzx.test;

import com.zzx.model.User;

import java.lang.reflect.Field;

public class TestReFlect属性 {
    public static void main(String[] args) throws Exception{
        /**
         * Field qgtDeclaredField(string name)返回一个Field 对象,该对象反映此Class 对象所表示的类或接口的指定已声明字段。
         * Field getField(string name.返回一个 Field对象,它反映此Class对象所表示的类或按口的指定公共成员字段。
         *
         * Field[] getDeclaredFields()返回Field对象的一个数组,这些对象反映此Class 对象所表示的类或接口所声明的所
         * Field[] getFields()返回一个包含某些Field对象的数组,这些对象反映此Class矿象所表示的类或接口的
         */

        Class clazz = User.class;
        Field uid = clazz.getDeclaredField("uid");//能获取到所有权限的数据
        System.out.println("uid"+uid);


        Field[] declaredFields = clazz.getDeclaredFields();//获得user表的所有属性
        for (Field field :declaredFields){
            System.out.println(field+"值");
        }


        Field uid2 = clazz.getField("uid");//只能获取public的,
        System.out.println("uid2"+uid2);


    }
}
