package com.lilong.java;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

/**
 *239.滑动窗口最大值
 */
public class MaxSlidingWindow {

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * @param nums 整数数组
     * @param k 滑动窗口的大小
     * @return 返回一个数组，数组中的每个元素为当前滑动窗口内的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1){
            return nums;
        }
        ThisQueue thisQueue = new ThisQueue();
        //用于记录当前是否为k的整数倍
        int flag = 0;
        //用于记录结果
        int[] result = new int[nums.length + 1 - k];
        //用于记录result的索引
        int i = 0;
        for (int num : nums) {
            thisQueue.push(num);
            flag++;
            if(flag>=k){
                if(flag > k){
                    thisQueue.pull(nums[flag - k -1]);
                }
                result[i++] = thisQueue.max();
            }

        }
        return result;

    }

    /**
     * 递减队列
     */
    static class  ThisQueue{
        Deque<Integer> deque = new LinkedList<>();

        /**
         * 向队列中删除元素
         * @param n 滑动窗口中要删除的值
         */
        public void push(int n){
            //在入队列时，如果队尾元素小于当前元素，将队尾元素删除，知道大于为止
            //是为了保证队列的单调递增
            //这边要为小于号而不是小于等于，因为只要保证非递减就行，并且队首元素等于当前元素时，不能将其删除，
            // 因为删除后就不能保证后面的数一定是比前面大的
            while (!deque.isEmpty()&&deque.getLast()<n){
                deque.removeLast();
            }
            deque.add(n);
        }

        /**
         * 向队列中添加元素
         * @param n 滑动窗口中要添加的元素
         */
        public void pull(int n){
            //如果滑动窗口的要删除的元素是当前的队首元素，将队首元素删除，否则什么都不用做
            if(!deque.isEmpty()&&deque.peek()==n){
                deque.remove();
            }
        }

        /**
         * 返回当前队列中的最大值，即队首元素
         * @return
         */
        public int max(){

            return deque.peek();
        }
    }
}
