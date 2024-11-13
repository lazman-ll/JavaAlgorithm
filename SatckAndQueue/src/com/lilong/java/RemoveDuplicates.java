package com.lilong.java;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicates {
    /**
     * 给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 s 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * @param s 初始字符串
     * @return 返回删除后的字符串
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c :chars){
            if(stack.isEmpty()){
                stack.push(c);
            }else if(stack.peek() == c){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
