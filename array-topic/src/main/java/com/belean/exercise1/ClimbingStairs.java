package com.belean;

/**
 * 70.爬楼梯(https://leetcode-cn.com/problems/climbing-stairs/)
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class ClimbingStairs {
    
    public static void main(String[] args) {
        int n = 5;

        // （1）递归
        System.out.println(climbStairs01(n));

        // （2）递归，备忘录
        System.out.println(climbStairs02(n));

        // （3）动态规划
        System.out.println(climbStairs03(n));

        // （4）斐波那契数列
        System.out.println(climbStairs04(n));

        // （5）通项公式矩阵形式
        System.out.println(climbStairs05(n));

        // （6）Binet's Formula解斐波那契公式
        System.out.println(climbStairs06(n));
    }

    /**
     * （1）递归
     * @param n
     * @return
     */
    public static int climbStairs01(int n) {
        return 0;
    }

    /**
     * （2）递归，备忘录
     * @param n
     * @return
     */
    public static int climbStairs02(int n) {
        return 0;
    }

    /**
     * （3）动态规划
     * @param n
     * @return
     */
    public static int climbStairs03(int n) {
        return 0;
    }

    /**
     * （4）斐波那契数列
     * @param n
     * @return
     */
    public static int climbStairs04(int n) {
        return 0;
    }

    /**
     * （5）通项公式矩阵形式
     * @param n
     * @return
     */
    public static int climbStairs05(int n) {
        return 0;
    }

    /**
     * （6）Binet's Formula
     * @param n
     * @return
     */
    public static int climbStairs06(int n) {
        return 0;
    }

}
