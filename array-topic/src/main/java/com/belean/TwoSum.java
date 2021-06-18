package com.belean;

import java.util.Arrays;

/**
 * 1.两数之和(https://leetcode-cn.com/problems/two-sum/)
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {

    public static void main(String[] args) {
        
        int[] nums = new int[]{2,7,11,15};
        // nums = new int[]{3,2,4};
        int target = 9;
        // target = 6;

        // （1）暴力求解
        System.out.println(Arrays.toString(twoSum01(nums, target)));


    }

    /**
     * （1）暴力求解
     * 时间复杂度：O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum01(int[] nums, int target) {
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    
}
