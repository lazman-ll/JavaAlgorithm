package com.lilong.java;

import java.util.Stack;

/**
 *20.有效字符串
 */
public class IsValid {
    /**
     *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * @param s 字符串
     * @return 有效返回true，反之返回false
     */
    public boolean isValid(String s) {
        //用栈实现
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if(stack.isEmpty()){
                stack.add(c);
                continue;
            }
            if (equalChar(stack.peek(), c)) {
                //可以配对，将栈顶元素出栈
                stack.pop();
            }else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean equalChar(char c1,char c2){
        if(c1=='('&&c2==')'){
            return true;
        }else if(c1=='['&&c2==']'){
            return true;
        }else return c1 == '{' && c2 == '}';
    }
}
