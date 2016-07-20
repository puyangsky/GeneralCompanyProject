package com.company.test;

import com.company.model.UserEntity;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/7/16.
 */
public class Test {
    public static void reflect(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
//            jo.put("id", userEntity.getId());
            System.out.println("jo.put(\"" + name + "\", userEntity.get" + name.substring(0,1).toUpperCase() +
                    name.substring(1) + "());");

        }
    }
    public static void splitTest(String s) {
        String[] names = s.split("\\.");
        System.out.println(names[0]);
    }

    public static void main(String[] args) {
        reflect(new UserEntity());
//        splitTest("abc.s");
//        int i = 1;
//        while (i<=108) {
//            System.out.println(i + ",");
//            i++;
//        }
    }
}
