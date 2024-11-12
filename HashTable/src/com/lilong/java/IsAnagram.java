package com.lilong.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @param s 字符串s
     * @param t 字符串t
     * @return 是，返回true ； 不是，返回false
     */
    public boolean isAnagram(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if(lengthT!=lengthS){
            //若两字符串长度不同，直接返回false
            return false;
        }
        List<Character> characterS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            characterS.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if(!characterS.contains(t.charAt(i))){
                return false;
            }
            Character c = t.charAt(i);
            characterS.remove(c);
        }
        return true;
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @param s 字符串s
     * @param t 字符串t
     * @return 是，返回true ； 不是，返回false
     * 使用record数组记录字符串中各个数字出现的次数
     */
    public static boolean isAnagram2(String s, String t){
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            record[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            record[index]--;
        }
        for (int count : record) {
            if(count != 0){
                return false;
            }
        }
        return true;
    }

}
