package com.lilong.test;

import com.lilong.java.MaxSlidingWindow;
import org.junit.jupiter.api.Test;

public class MaxSlidingWindowTest {
    @Test
    public void test01(){
        MaxSlidingWindow sample = new MaxSlidingWindow();
        int [] nums = {-7,-8,7,5,7,1,6,0};
        sample.maxSlidingWindow(nums,4);
    }
}
