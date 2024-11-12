package com.lilong.java;

import java.util.Arrays;
import java.util.HashMap;

public class FourSumCount {
    /**
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     * @param nums1 整数数组
     * @param nums2 整数数组
     * @param nums3 整数数组
     * @param nums4 整数数组
     * @return 多少个元组 (i, j, k, l) 能满足
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //定义HashMap，key为nums1+nums2的和，value为该值出现的次数
        HashMap<Integer,Integer> hm = new HashMap<>();
        //遍历数组1和数组2
        for (int i : nums1) {
            for (int j : nums2) {
                //计算两数之和
                int temp = i + j;
                //如果map中已经有了
                if(hm.containsKey(temp)){
                    //将value加1即可
                    int count = hm.get(temp) + 1;
                    hm.put(temp,count);
                }else {
                    //hm中没有，直接将该key放入，并将value设为1
                    hm.put(temp,1);
                }
            }
        }
        //用来记录总数
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int temp = -(i + j);
                if(hm.containsKey(temp)){
                    count = count + hm.get(temp);
                }
            }
        }
        return count;

    }
}
