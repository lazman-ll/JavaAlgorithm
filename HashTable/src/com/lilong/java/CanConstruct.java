package com.lilong.java;

public class CanConstruct {
    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * @param ransomNote 字符串
     * @param magazine 字符串
     * @return 如果可以，返回 true ；否则返回 false 。
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (int i = 0,j = 0; i < magazine.length()||j < ransomNote.length(); i++,j++) {
            if (i < magazine.length()) {
                int index1 = magazine.charAt(i) - 'a';
                array[index1]++;
            }
            if (j < ransomNote.length()) {
                int index2 = ransomNote.charAt(j) - 'a';
                array[index2]--;
            }
        }
        for (int i : array) {
            if(i < 0){
                return false;
            }
        }
        return true;
    }
}
