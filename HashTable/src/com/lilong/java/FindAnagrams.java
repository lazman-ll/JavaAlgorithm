package com.lilong.java;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * @param s 字符串
     * @param p 异位词的基准
     * @return 返回子串的起始索引
     */
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            return new ArrayList<>();
        }
        int length = p.length();
        int right = length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= s.length() - length; i++) {
            String substring = s.substring(i, right);
            if (IsAnagram.isAnagram2(substring, p)) {
                list.add(i);
            }
            right++;
        }
        return list;
    }


    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * @param s 字符串
     * @param p 异位词的基准
     * @return 返回子串的起始索引
     * 方法二：使用滑动窗口，且统计滑动窗口和字符串 p 中每种字母数量的差
     */
    public List<Integer> findAnagrams2(String s, String p) {
        // 获取字符串s的长度
        int sLen = s.length();
        // 获取字符串p的长度
        int pLen = p.length();

        // 如果s的长度小于p的长度，那么s中不可能存在与p构成异位词的子串，直接返回空列表
        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        // 用于存储找到的异位词子串的起始索引的列表
        List<Integer> ans = new ArrayList<Integer>();

        // 创建一个长度为26的整数数组，用于记录字符出现次数的差异
        // 假设字符串只包含小写英文字母，'a' - 'a' = 0，'b' - 'a' = 1，以此类推，可通过字符减去'a'得到在数组中的索引
        int[] count = new int[26];

        // 初始化阶段：遍历字符串p的长度范围，统计字符串p和字符串s前pLen个字符中每个字符出现次数的差异
        for (int i = 0; i < pLen; ++i) {
            // 统计字符串s中第i个字符出现的次数，通过将字符减去'a'得到在count数组中的索引，然后对应索引位置的值加1
            ++count[s.charAt(i) - 'a'];
            // 统计字符串p中第i个字符出现的次数，同样通过将字符减去'a'得到在count数组中的索引，然后对应索引位置的值减1
            --count[p.charAt(i) - 'a'];
        }

        // 计算初始状态下字符出现次数不同的字符种类数量
        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            // 如果某个字符在count数组中的计数不为0，说明该字符在s和p中的出现次数不同，differ加1
            if (count[j]!= 0) {
                ++differ;
            }
        }

        // 如果初始状态下字符出现次数不同的字符种类数量为0，说明字符串s的前pLen个字符与字符串p是异位词
        // 将起始索引0添加到结果列表ans中
        if (differ == 0) {
            ans.add(0);
        }

        // 滑动窗口阶段：通过滑动窗口遍历字符串s剩下的部分，窗口大小为pLen
        for (int i = 0; i < sLen - pLen; ++i) {
            // 处理窗口左侧移除的字符
            if (count[s.charAt(i) - 'a'] == 1) {
                // 如果窗口中要移除的字符s[i]在count数组中的计数为1，说明移除该字符后，与字符串p中该字符的数量从不同变得相同
                // 那么字符出现次数不同的字符种类数量differ减1
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                // 如果窗口中要移除的字符s[i]在count数组中的计数为0，说明移除该字符后，与字符串p中该字符的数量从相同变得不同
                // 那么字符出现次数不同的字符种类数量differ加1
                ++differ;
            }
            // 将窗口左侧移除的字符在count数组中的计数减1，以更新其出现次数统计
            --count[s.charAt(i) - 'a'];

            // 处理窗口右侧新加入的字符
            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                // 如果窗口右侧新加入的字符s[i + pLen]在count数组中的计数为-1，说明加入该字符后，与字符串p中该字符的数量从不同变得相同
                // 那么字符出现次数不同的字符种类数量differ减1
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                // 如果窗口右侧新加入的字符s[i + pLen]在count数组中的计数为0，说明加入该字符后，与字符串p中该字符的数量从相同变得不同
                // 那么字符出现次数不同的字符种类数量differ加1
                ++differ;
            }
            // 将窗口右侧新加入的字符在count数组中的计数加1，以更新其出现次数统计
            ++count[s.charAt(i + pLen) - 'a'];

            // 如果经过上述窗口滑动操作后，字符出现次数不同的字符种类数量为0，说明当前窗口内的字符串与字符串p是异位词
            // 将当前窗口的起始索引（i + 1）添加到结果列表ans中
            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        // 返回存储所有异位词子串起始索引的列表
        return ans;
    }
}
