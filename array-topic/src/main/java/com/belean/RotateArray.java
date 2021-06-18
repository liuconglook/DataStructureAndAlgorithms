package com.belean;

import java.util.Arrays;

/**
 * 189.旋转数组https://leetcode-cn.com/problems/rotate-array/
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateArray {

    public static void main(String[] args) {
        
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        //nums = new int[]{-1,-100,3,99};

        //rotate01(nums, 2);
        rotate02(nums, 4);
        System.out.println(Arrays.toString(nums));

    }
    

    public static void rotate01(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 1) {
            return;
        }

        while(k-- > 0) {
            int num = nums[nums.length-1];
            int i = nums.length-1;
            while(i > 0) {
                nums[i] = nums[i-1];
                i--;
            }
            nums[0] = num;
        }
    }

    public static void rotate02(int[] nums, int k) {
        
        if(nums == null || nums.length < 2 || k < 1) {
            return;
        }

        int num = nums[0];
        int i = 0, j = 0, x = 0, y = 0;
        while(i++ < nums.length - k) {
            x = (j-k)<0?nums.length+(j-k):j-k;
            if(x == 0) {
                j = (j-1)<0?nums.length+(j-1):j-1;
                x = (j-k)<0?nums.length+(j-k):j-k;
                y = nums[j];
            }
            nums[j] = nums[x];
            j = x;
        }
        if(k%2 == 0) {
            nums[j] = y;
            nums[j-1] = num;
        }else{
            nums[k>nums.length-1?nums.length-k:k] = num;
        }
        
    }

    public static void rotate02(int[] nums, int k) {
        
        if(nums == null || nums.length < 2 || k < 1) {
            return;
        }

        int num = nums[0];
        int i = 0, j = 0, x = 0, y = 0;
        while(i++ < nums.length - k) {
            x = (j-k)<0?nums.length+(j-k):j-k;
            if(x == 0) {
                j = (j-1)<0?nums.length+(j-1):j-1;
                x = (j-k)<0?nums.length+(j-k):j-k;
                y = nums[j];
            }
            nums[j] = nums[x];
            j = x;
        }
        if(k%2 == 0) {
            nums[j] = y;
            nums[j-1] = num;
        }else{
            nums[k>nums.length-1?nums.length-k:k] = num;
        }
        
    }
    
    // 1,2,3,4,5
    // 4,2,3,4,5 0-3
    // 4,2,3,2,5 3-1
    // 4,5,3,2,5 1-4
    // 4,5,3,2,3 4-2
    // 4,5,1,2,3 nums[0+k] = num;

    // -1,-100,3,99
    // 3,-100,3,99
    // 3,99,3,99
    // 
}
