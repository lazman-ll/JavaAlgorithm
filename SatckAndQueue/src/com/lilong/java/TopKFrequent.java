package com.lilong.java;

import java.util.*;

public class TopKFrequent {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     * @param nums 整数数组
     * @param k 整数
     * @return 以数组的形式返回出现频率前 k 高的元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!hashMap.isEmpty()&&hashMap.containsKey(nums[i])){
                Integer count = hashMap.get(nums[i]);
                hashMap.put(nums[i],++count);
            }else {
                hashMap.put(nums[i],1);
            }
        }
        //创建小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(pq.size() < k){
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else {
                if(pq.peek()[1] < entry.getValue()){
                    pq.remove();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }
        return result;
    }


}
