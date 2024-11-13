package com.lilong.java;

public class StrStr {

    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果 needle 不是 haystack 的一部分，则返回  -1 。
     * @param haystack 大的字符串
     * @param needle 小的字符串
     * @return 找到返回第一个的下标，没找到返回-1
     */
    public int strStr(String haystack, String needle) {
        int length = needle.length();
        char start = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i)==start){
                int end = length + i;
                if(end <= haystack.length()){
                    String substring = haystack.substring(i, length + i);
                    if(substring.equals(needle)){
                        return i;
                    }
                }else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
