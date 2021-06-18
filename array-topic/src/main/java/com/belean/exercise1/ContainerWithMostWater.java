package com.belean;

/**
 * 11.盛最多水的容器(https://leetcode-cn.com/problems/container-with-most-water/)
 * - 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * - 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * - 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * - 说明：你不能倾斜容器。
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

        // 初始数组
        int[] arr = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        // （1）暴力求解
        System.out.println(maxArea01(arr));

        // （2）双指针
        System.out.println(maxArea02(arr));

    }

    /**
     * （1）暴力求解
     * 穷举组合，求出最大
     * 时间复杂度：O(n^2)
     */
    public static int maxArea01(int[] arr) {
        return 0;
    }

    /**
     * （2）双指针
     * 左右同时进行组合，求出最大
     * 时间复杂度：O(n)
     */
    public static int maxArea02(int[] arr) {
        return 0;
    }

}
