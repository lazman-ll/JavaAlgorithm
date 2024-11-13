package com.lilong.java;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225.用队列实现栈
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /**
     * 初始化栈
     */
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    /**
     * 入栈
     * @param x 入栈元素
     */
    public void push(int x) {
        if(!queue1.isEmpty()){
            //在非空的队列里面添加元素
            queue1.add(x);
        }else {
            queue2.add(x);
        }
    }

    /**
     * 出栈
     * @return 返回出栈的元素
     */
    public int pop() {
        if(!queue1.isEmpty()){
            //queue1不为空，将queue1的元素全部添加到queue2中，并返回最后一个元素
            return myPop(queue2,queue1);
        }else {
            return myPop(queue1,queue2);
        }
    }

    private int myPop(Queue<Integer> queueIn,Queue<Integer> queueOut){
        int result = 0;
        while (!queueOut.isEmpty()){
            //最后一个元素不能入队列
            result = queueOut.poll();
            if(!queueOut.isEmpty()){
                queueIn.add(result);
            }

        }
        return result;
    }

    /**
     * 返回栈顶元素
     * @return 栈顶元素
     */
    public int top() {
        int pop = pop();
        push(pop);
        return pop;
    }

    /**
     * 栈是否为空
     * @return 为空，返回true，反之，返回false
     */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */