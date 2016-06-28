package com.company.util;

/**
 * Created by Administrator on 2016/6/28.
 */
public class StringCheck {
    public static boolean isNullOrEmpty (String s) {
        if (s.equals("") || s == null) {
            return true;
        }
        return false;
    }
}
