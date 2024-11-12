package com.lilong.java;

import java.util.*;

public class Intersection {
    /**
     * 给定两个数组 nums1 和 nums2 ，返回它们的交集，输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回交集，且元素唯一
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if(set.contains(i)){
                result.add(i);
            }
        }
        int[] re = new int[result.size()];
        int index = 0;
        for (Integer i : result) {
            re[index++] = i;
        }
        return re;
    }
}
