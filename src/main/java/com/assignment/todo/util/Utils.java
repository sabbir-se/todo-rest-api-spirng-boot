package com.assignment.todo.util;

import java.util.List;

/**
 * Created by sabbir on 12/2/21.
 */
public class Utils {

    public static boolean isNullOrEmpty(String s){
        return s == null || s.isEmpty();
    }

    public static boolean isNullOrEmpty(List list){
        return list == null || list.size() == 0;
    }
}
