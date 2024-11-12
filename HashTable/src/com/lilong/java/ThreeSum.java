package com.lilong.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
     * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
     * @param nums 整数数组
     * @return 返回所有和为 0 且不重复的三元组
     */
    /*
    * 本题使用双指针方法
    * */

    public List<List<Integer>> threeSum(int[] nums) {
        //定义集合
        List<List<Integer>> res = new ArrayList<>();

        //先将数组按照升序排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //i的去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }

            //定义左右指针
            int left = i + 1;
            int right = nums.length - 1;
            left = i + 1;
            while (left < right){
                //定义集合存储集合
                List<Integer> list = new ArrayList<>();
                int temp1 = nums[i];
                int temp2 = nums[left];
                int temp3 = nums[right];
                if((temp1 + temp2 +temp3) < 0){
                    left++;
                }else if((temp1 + temp2 +temp3) > 0){
                    right--;
                }else {
                    list.add(temp1);
                    list.add(temp2);
                    list.add(temp3);
                    res.add(list);
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1])
                        right--;
                    while (right > left && nums[left] == nums[left + 1])
                        left++;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

}
