package com.lilong.test;

import com.lilong.java.ThreeSum;
import org.junit.jupiter.api.Test;

public class ThreeSumTest {

    @Test
    public void test01(){
        ThreeSum sample = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        sample.threeSum(nums);
    }
}
