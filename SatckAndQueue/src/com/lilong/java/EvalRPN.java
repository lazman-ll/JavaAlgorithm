package com.lilong.java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 */
public class EvalRPN {
    /**
     * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
     * 请你计算该表达式。返回一个表示表达式值的整数。
     * @param tokens 字符串数组
     * @return 返回表达式值
     */
    public int evalRPN(String[] tokens) {
        //用栈实现，遇到操作符的时候直接抛出前面的两个值，进行计算后入栈
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            //判断该字符串是否为操作符
            int operator = isOperator(token);
            if(operator == 0){
                //非操作符，转为数字后存入stack
                stack.push(strToInt(token));
            } else {
                //操作符，将前两个数字出栈
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if(operator == 1){
                    //是+
                    stack.push(num2 + num1);
                }else if (operator == 2){
                    //是-
                    stack.push(num2 - num1);
                }else if (operator == 3){
                    //是*
                    stack.push(num2 * num1);
                }else if (operator == 4){
                    //是/
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }

    /**
     * 判断该字符串是否为操作符
     * @param str 字符串
     * @return 返回整数
     */
    private int isOperator(String str){
        return switch (str) {
            case "+" -> 1;
            case "-" -> 2;
            case "*" -> 3;
            case "/" -> 4;
            case null, default -> 0;
        };
    }

    /**
     * 将字符串转换为整数
     * @param str 字符串
     * @return 返回一个整数
     */
    private int strToInt(String str){
        char[] charArray = str.toCharArray();
        int result = 0;
        for (char c : charArray) {
            if (c >= '0' && c <= '9') {
                int temp = c - '0';
                result = result * 10 + temp;
            }
        }
        //可能有负号
        if(charArray[0]=='-'){
            return result * -1;
        }
        return result;
    }

    /**
     * 可以使用java的内置函数
     * @param tokens
     * @return
     */
    public int evalRPN2(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                //使用java的内置函数，直接将字符串转为整数
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}