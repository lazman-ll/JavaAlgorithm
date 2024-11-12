package com.lilong.java;

import java.util.HashSet;

public class IsHappy {

    /* 「快乐数」 定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     */

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * @param n 正整数
     * @return true表示该数为快乐数，反之不是
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n!=1&&!set.contains(n)){
            set.add(n);
            n = getNextNum(n);

        }
        return n==1;
    }

    /**
     * 获取下一个数(各个位上平方的和)
     * @param num
     * @return
     */
    private int getNextNum(int num){
        int res = 0;
        while (num > 0){
            int temp = num % 10;
            res += temp * temp;
            num = num / 10;
        }
        return res;
    }
}
