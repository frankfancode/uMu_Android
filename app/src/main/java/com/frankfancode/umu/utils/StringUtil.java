package com.frankfancode.umu.utils;

/**
 * Created by FrankFan on 16/6/13.
 */
public class StringUtil {
    public static boolean isBlank(String s) {

        if (s == null || s.isEmpty() || s.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEqual(String a, String b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && a.equals(b)) {
            return true;
        }


        return false;
    }


}
