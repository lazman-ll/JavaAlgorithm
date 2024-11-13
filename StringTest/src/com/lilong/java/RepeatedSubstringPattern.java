package com.lilong.java;

public class RepeatedSubstringPattern {

    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * @param s 非空字符串
     * @return 可以返回true否之返回false
     */
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        int length = str.length() -1;
        str = str.substring(1,length);
        return str.contains(s);
    }
    //TODO:使用KMP方法解决该问题
}
