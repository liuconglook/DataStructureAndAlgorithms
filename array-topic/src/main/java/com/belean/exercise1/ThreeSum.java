package com.belean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和(https://leetcode-cn.com/problems/3sum/)
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        //nums = new int[]{};
        //nums = new int[]{0};

        // （1）暴力求解
        print(threeSum01(nums));

        // （2）双指针
        print(threeSum02(nums));
    }

    /**
     * 打印
     * @param list
     */
    public static void print(List<List<Integer>> list) {
        System.out.println("[");
        for(int i=0;i<list.size();i++) {
            List<Integer> group = list.get(i);
            System.out.print(" [");
            for(int j=0;j<group.size();j++){
                Integer num = group.get(j);
                if(j == group.size()-1) {
                    System.out.print(num);
                }else{
                    System.out.print(num + ",");
                }
            }
            if(i == list.size()-1) {
                System.out.println("]");
            }else{
                System.out.println("],");
            }
        }
        System.out.println("]");
    }

    /**
     * （1）暴力求解
     * 三层遍历穷举组合
     * 时间复杂度：O(n^4)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum01(int[] nums) {
        return null;
    }

    /**
     * （2）双指针
     * 时间复杂度：O(n^2)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum02(int[] nums) {
        return null;
    }

    
}
