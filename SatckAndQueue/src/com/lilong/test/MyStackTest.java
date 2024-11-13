package com.lilong.test;

import com.lilong.java.MyStack;
import org.junit.jupiter.api.Test;

public class MyStackTest {

    @Test
    public void test01(){
        MyStack sample = new MyStack();
        sample.push(1);
        int pop = sample.pop();
        System.out.println("pop = " + pop);
        boolean empty = sample.empty();
        System.out.println("empty = " + empty);
    }
}
