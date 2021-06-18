package com.belean;

import java.util.Arrays;

/**
 * 26.删除有序数组中的重复项https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    
    public static void main(String[] args) {
        
        int[] nums = new int[]{1,1,2};
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates01(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates01(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }

        int i = 0,j = 1;
        while(j<nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            }else{
                nums[++i] = nums[j++];
            }
        }
        return i+1;
    }
}
