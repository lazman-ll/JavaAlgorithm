package com.lilong.test;

import com.lilong.java.EvalRPN;
import org.junit.jupiter.api.Test;

public class EvalRPNTest {

    @Test
    public void test01(){
        String[] strings = {"4","13","5","/","+"};
        EvalRPN sample = new EvalRPN();
        sample.evalRPN(strings);
    }
}
