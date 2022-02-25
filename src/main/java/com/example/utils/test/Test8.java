package com.example.utils.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Cc
 * @Date: 2021/11/25 16:04
 */
public class Test8 {

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /** 驼峰转下划线,效率比上面高 */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
