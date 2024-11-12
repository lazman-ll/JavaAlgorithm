package com.lilong.test;

import com.lilong.java.FourSum;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FourSumTest {

    @Test
    public void test01(){
        FourSum sample = new FourSum();
        int[] nums =  {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> lists = sample.fourSum(nums, target);
    }
}
