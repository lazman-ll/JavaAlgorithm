package com.lilong.java;

public class ReverseStr {

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * @param s 字符串
     * @param k 整数
     * @return 返回反转好的字符串
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i +=2*k) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end){
                char c = chars[start];
                chars[start] = chars[end];
                chars[end] = c;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
