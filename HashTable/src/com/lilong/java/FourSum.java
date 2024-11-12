package com.lilong.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
     * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
     * （若两个四元组元素一一对应，则认为两个四元组重复）：
     * （1）0 <= a, b, c, d < n
     * （2）a、b、c 和 d 互不相同
     * （3）nums[a] + nums[b] + nums[c] + nums[d] == target
     * @param nums 整数数组
     * @param target 目标值
     * @return 返回列表
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //定义结果列表
        List<List<Integer>> result = new ArrayList<>();
        //先将数组排序
        Arrays.sort(nums);
        //如果最小数就大于目标值直接返回
        if(nums[0]>target && target >= 0){
            return result;
        }
        //进行循环
        for (int i = 0; i < nums.length; i++) {
            //去除重复值
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //去除重复值
                if(j> i + 1 &&nums[j] == nums[j-1]){
                    continue;
                }
                //定义指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    int temp1 = nums[i];
                    int temp2 = nums[j];
                    int temp3 = nums[left];
                    int temp4 = nums[right];
                    long sum = (long)temp1 + temp2 + temp3 + temp4;
                    if(sum < (long)target){
                        left++;
                    }else if(sum > (long)target){
                        right--;
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(temp1);
                        list.add(temp2);
                        list.add(temp3);
                        list.add(temp4);

                        result.add(list);
                        //去除重复部分
                        while (right > left && nums[right] == nums[right - 1])
                            right--;
                        while (right > left && nums[left] == nums[left + 1])
                            left++;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}