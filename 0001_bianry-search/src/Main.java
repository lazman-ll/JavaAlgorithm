import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[]a = {0,1,2,2};
        int i = totalFruit(a);
        System.out.println("i = " + i);
    }

    /**
     * 二分查找
     * @param nums 一个升序数组
     * @param target 要找的目标值
     * @return 找不到返回-1，找到返回索引
     */
    public int search(int[] nums, int target) {
        //首元素
        int low =  0;
        //末尾元素
        int high = nums.length - 1;
        //执行循环，最后要考虑i=j时指向的那个元素
        while(low <= high){
            //获取中间值,使用位移运算，防止溢出
            int m = (low+high) >>> 1;
            if(target < nums[m]){
                //目标值在左侧
                high = m -1;
            }else if(nums [m] < target ){
                //目标值在右侧
                low = m +1;
            }else {
                //找到目标值
                return m;
            }
        }
        //找不到返回-1
        return -1;
    }

    /**
     * 搜素插入位置01
     * @param nums 一个升序且无重复数字的数组
     * @param target 目标值
     * @return 找到返回索引，找不到返回其应被插入位置
     */
    public int searchInsert01(int[] nums, int target) {
        //首元素
        int low =  0;
        //末尾元素再后面一位
        int high = nums.length ;
        //执行循环，此处最后不用考虑i=j时指向的那个元素
        while(low < high){
            //获取中间值,使用位移运算，防止溢出
            int m = (low+high) >>> 1;
            if(target < nums[m]){
                //目标值在左侧
                high = m ;
            }else if(nums [m] < target ){
                //目标值在右侧
                low = m + 1;
            }else {
                //找到目标值
                return m;
            }
        }
        //找不到返回其应被插入的位置
        return low ;
    }

    /**
     * 搜素插入位置02，使用Leftmost的二分查找
     * @param nums 一个升序(可有重复数字)数组
     * @param target 目标值
     * @return 找到返回索引，找不到返回其应被插入位置
     */
    public int searchInsert02(int[] nums, int target) {
        //首元素
        int low =  0;
        //末尾元素再后面一位
        int high = nums.length - 1 ;
        //执行循环，此处最后不用考虑i=j时指向的那个元素
        while(low <= high){
            //获取中间值,使用位移运算，防止溢出
            int m = (low+high) >>> 1;
            if(target <= nums[m]){
                //目标值在左侧,或相等
                high = m -1;
            }else {
                //目标值在右侧
                low = m + 1;
            }
        }
        //找不到返回其应被插入的位置
        return low ;
    }

    /**
     * 排序数组中查找元素的第一个和最后一个位置
     * @param nums 非递减顺序的排序数组
     * @param target 目标值
     * @return target的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int candidate = -1 ;
        //返回第一个元素
        while(low <= high){
            int m = (low + high) >>>1;
            if(target < nums[m]){
                high = m -1;
            }else if (nums[m] < target ){
                low = m +1;
            }else {
                candidate = m;
                high = m -1;
            }
        }
        int [] result = new int[2];
        result[0]= candidate;
        //返回最后一个元素
        low = 0;
        high = nums.length - 1;
        while(low <= high){
            int m = (low + high) >>>1;
            if(target < nums[m]){
                high = m -1;
            }else if (nums[m] < target ){
                low = m +1;
            }else {
                candidate = m;
                low = m +1;
            }
        }
        result[1]=candidate;
        return result;
    }

    /**
     * 求x的平方根
     * @param x 原始值
     * @return 结果保留整数部分，小数，去除
     */
    public static int mySqrt(int x) {
        if( x == 0||x == 1){
            return x;
        }
        int i = 0;
        int j = x;
        while(i +1 < j){
            //求取中间值
            int m = (j +i) >>> 1;
            //使用x/m > m而不是m*m<x,保证不溢出
            if(x/m > m){
                //值比其小
                i = m;
            }else if(x/m < m){
                //值比其大
                j = m ;
            }else {
                return m;
            }
        }
        return i;
    }

    /**
     * 完全平方数
     * @param num 给定数
     * @return num为完全平方数，返回true，反之返回false
     */
    public static boolean isPerfectSquare(int num) {
        if(num == 0 ||num == 1){
            return true;
        }
        int i = 0;
        int j = num;
        while(i + 1 < j){
            int m = (i+j)>>>1;
            if(num*1.0/m < m){
                j = m;
            }else if(num*1.0/m > m){
                i = m;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * @param target 目标值
     * @param nums 给定的正整数数组
     * @return 最短连续子数组的长度，不存在返回0
     */
    public int minSubArrayLen(int target, int[] nums) {
        //存储最终返回的值，处置为int类的最大值
        int result = Integer.MAX_VALUE;
        //滑动窗口中数组的值的和
        int sum = 0;
        //i表示滑动窗口的起点
        int i = 0;

        //j表示滑动窗口的终点
        for (int j = 0; j < nums.length; j++) {
            //计算滑动窗口中的和
            sum += nums[j];
            //若滑动窗口中的和 >= target,
            while (sum>=target){
                // 1.表示需要记录该滑动窗口的长度，并比较是否为更短的
                int tempResult = j - i + 1;
                result = Math.min(result, tempResult);
                // 2.要改变滑动窗口的起始位置即 i++ ，并将sum值减去num[i]
                sum -= nums[i++];
            }
        }
        //若值没变，为初始值，表示没有符合条件的返回0
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 904. 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
     * @param fruits 整数数组
     * @return 可以收集的水果的最大数目
     */
    public static int totalFruit(int[] fruits) {
        //利用滑动窗口解决该问题
        //1. 定义集合表示篮子，size为2
        List<Integer> bucket = new ArrayList<>();
        //2. 定义滑动窗口的起始
        int i = 0;
        //3. 定义装的水果数量
        int result = 0;

        int tempResult = 0;
        //遍历 j表示滑动窗口的终点
        for (int j = 0; j < fruits.length; j++) {
            //该水果不是篮子其中的一个，需要再占一个位子
            if(!bucket.contains(fruits[j])){
                //篮子还有位置
                if(bucket.size() < 2){
                    bucket.add(fruits[j]);
                    tempResult++;
                }else {
                    //篮子没有位置
                    //直接结束，进行判断比较是否更多
                    result = Math.max(result,tempResult);
                    //更新滑动窗口的起始位置
                    while(bucket.get(0)==fruits[i]){
                        i++;
                    }
                    bucket.set(0,bucket.get(1));
                    bucket.set(1,fruits[j]);
                    j = i - 1;
                    tempResult = 0;
                }
            }else {
                //该水果是篮子其中的一个，不需要再占一个位子，数量直接加一
                tempResult++;
            }
        }
        return Math.max(result,tempResult);
    }

}