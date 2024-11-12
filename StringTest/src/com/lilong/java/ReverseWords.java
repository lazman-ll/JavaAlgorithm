package com.lilong.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseWords {

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * @param s 字符串
     * @return 返回反转好的字符串
     */
    public String reverseWords(String s) {
        int start = 0;
        int end = s.length() - 1;
        //删除前面的多余空格
        while (s.charAt(start)==' '){
            start++;
        }
        //删除后面多余的空格
        while (s.charAt(end)==' '){
            end--;
        }
        //删除中间多余的空格
        StringBuffer sb = new StringBuffer();
        while (start <= end){
            if(s.charAt(start)!=' '||sb.charAt(sb.length() - 1) != ' '){
                sb.append(s.charAt(start));
            }
            start++;
        }
        s = sb.toString();
        String[] strings = s.split(" ");
        sb = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if(i!= 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
