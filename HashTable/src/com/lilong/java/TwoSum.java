package com.lilong.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * @param nums 整数数组
     * @param target 整数目标值
     * @return 返回一个数组
     */
    public int[] twoSum(int[] nums, int target) {
        //使用hashmap，因为本题目要返回数组下标，所以我们需要将元素的值，和该元素的索引都存起来。
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            //先判断hashmap中是否有配对的元素，后存入元素值，可以保证元素不会和自己配对
            if(map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;
            }
            //键存入元素值，值存入该元素的索引
            map.put(nums[i],i);
        }
        return res;
    }
}
