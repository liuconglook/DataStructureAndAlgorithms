package com.belean;

import java.util.Arrays;

/**
 * MoveZeroes
 */
public class MoveZeroes {

    public static void main(String[] args) {
        
        moveZeroes01();

        moveZeroes02();

        moveZeroes03();

        moveZeroes04();

        moveZeroes05();

    }

    /**
     * 283.移动零 
     * （1）暴力求解
     * 采用冒泡排序的思路
     */
    public static void moveZeroes01() {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    int swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 283.移动零
     * （2）两次遍历，版本1
     * 第一次遍历，将非0的放入前排
     * 第二次遍历，将前排后的位置清零
     */
    public static void moveZeroes02() {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };

        int j = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for(int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 283.移动零 
     * （2）两次遍历，版本2
     * 优化处1，跳过已排好（i==j）的情况，防止做无意义的排序（赋值）操作。
     */
    public static void moveZeroes03() {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        nums = new int[] { 1, 3, 12, 0, 0 };

        int j = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                if(i != j) { // 优化处1
                    nums[j] = nums[i];
                }
                j++;
            }
        }

        for(int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 283.移动零 
     * （2）两次遍历，版本3
     * 两次遍历，变成一次遍历
     * 优化处2，将元素往前挪后，将之前位置赋值0，这样就不需要整体挪完后再遍历一次赋值0了。
     */
    public static void moveZeroes04() {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        // nums = new int[] { 1, 3, 12, 0, 0 };

        int j = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                if(i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0; // 优化处2
                }
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 283.移动零 
     * （2）快排思路
     * 将不为0的元素替换到前面，为0的元素就在后面了
     */
    public static void moveZeroes05() {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        nums = new int[] { 1, 3, 12, 0, 0 };

        int j = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                if(i != j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}