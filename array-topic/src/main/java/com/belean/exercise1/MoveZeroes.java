package com.belean;

import java.util.Arrays;

/**
 * 283.移动零(https://leetcode-cn.com/problems/move-zeroes/)
 * - 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        
        // 初始数据
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        // nums = new int[] { 1, 3, 12, 0, 0 }; // 已经排好序的数组

        // （1）暴力求解，冒泡思路
        System.out.println(Arrays.toString(moveZeroes01(nums)));

        // （2）两次遍历1
        System.out.println(Arrays.toString(moveZeroes02(nums)));
        // （2）两次遍历2
        System.out.println(Arrays.toString(moveZeroes03(nums)));
        // （2）两次遍历3
        System.out.println(Arrays.toString(moveZeroes04(nums)));

        // （3）快排思路
        System.out.println(Arrays.toString(moveZeroes05(nums)));

    }

    /**
     * （1）暴力求解
     * 采用冒泡排序的思路
     * 时间复杂度：O(n^2)
     */
    public static int[] moveZeroes01(int[] nums) {
        return null;
    }

    /**
     * （2）两次遍历，版本1
     * 第一次遍历，将非0的放入前排
     * 第二次遍历，将前排后的位置清零
     * 时间复杂度：O(n)
     */
    public static int[] moveZeroes02(int[] nums) {
        return null;
    }

    /**
     * （2）两次遍历，版本2
     * 优化处1，跳过已排好（i==j）的情况，防止做无意义的排序（赋值）操作。
     * 时间复杂度：O(n)
     */
    public static int[] moveZeroes03(int[] nums) {
        return null;
    }

    /**
     * （2）两次遍历，版本3
     * 两次遍历，变成一次遍历
     * 优化处2，将元素往前挪后，将之前位置赋值0，这样就不需要整体挪完后再遍历一次赋值0了。
     * 时间复杂度：O(n)
     */
    public static int[] moveZeroes04(int[] nums) {
        return null;
    }

    /**
     * （3）快排思路
     * 将不为0的元素替换到前面，为0的元素就在后面了
     * 时间复杂度：O(logn)
     */
    public static int[] moveZeroes05(int[] nums) {
        return null;
    }
}