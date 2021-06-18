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
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs01(n - 1) + climbStairs01(n - 2);
    }

    /**
     * （2）递归，备忘录
     * @param n
     * @return
     */
    public static int climbStairs02(int n) {
        int memo[]  = new int[n + 1];
        return climbStairsMemo(n, memo);
    }
    public static int climbStairsMemo(int n, int[] memo) {
        if(memo[n] > 0) {
            return memo[n];
        }
        if(n == 1) {
            memo[n] = 1;
        }else if(n == 2){
            memo[n] = 2;
        }else {
            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * （3）动态规划
     * @param n
     * @return
     */
    public static int climbStairs03(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * （4）斐波那契数列
     * @param n
     * @return
     */
    public static int climbStairs04(int n) {
        if(n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for(int i=3; i<=n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * （5）通项公式矩阵形式
     * @param n
     * @return
     */
    public static int climbStairs05(int n) {
        int[][] m = {{0, 1}, {1, 1}};
        int[][] res = pow(m, n);
        return res[1][1];
    }
    public static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while(n > 0) {
            if((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        c[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        c[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        c[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        c[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        return c;
    }

    /**
     * （6）Binet's Formula
     * @param n
     * @return
     */
    public static int climbStairs06(int n) {
        double sqrt5 = Math.sqrt(5);
        double result = (Math.pow((1+sqrt5)/2, n+1) - Math.pow((1-sqrt5)/2, n+1)) / sqrt5;
        return (int) result;
    }

}
