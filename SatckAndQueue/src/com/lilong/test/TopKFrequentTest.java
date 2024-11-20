package com.lilong.test;

import com.lilong.java.TopKFrequent;
import org.junit.jupiter.api.Test;

public class TopKFrequentTest {

    @Test
    public void test01(){
        TopKFrequent sample = new TopKFrequent();
        int[] nums = {4,1,-1,2,-1,2,3};
        sample.topKFrequent(nums,2);
    }
}
