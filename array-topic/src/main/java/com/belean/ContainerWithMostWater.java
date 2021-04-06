package com.belean;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        containerWithMostWater01();

        containerWithMostWater02();

    }

    /**
     * 11.盛最多水的容器 
     * （1）暴力求解
     * 穷举组合，求出最大
     */
    public static void containerWithMostWater01() {

        // 初始数组
        int[] arr = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        // 最大容量
        int max = 0;

        // 双重遍历，找组合n*n
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 过滤掉相同的两条线n*n-n
                if (i != j) {
                    // 求解容量
                    int capacity = Math.abs(i - j) * Math.min(arr[i], arr[j]);
                    // 存入最大
                    if (capacity > max) {
                        max = capacity;
                    }
                }
            }
        }

        // 打印结果
        System.out.println(max);

    }

    /**
     * 11.盛最多水的容器 
     * （2）快慢指针
     * 左右同时进行组合，求出最大
     */
    public static void containerWithMostWater02() {

        // 初始数组
        int[] arr = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        // 最大容量
        int max = 0;

        for (int i = 0, j = arr.length - 1; i != j;) {

            // 求解容量
            int capacity = Math.abs(i - j) * Math.min(arr[i], arr[j]);

            // 存入最大
            if (capacity > max) {
                max = capacity;
            }

            // i和j谁先走?,短的先走
            if (arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }
        }

        // 打印结果
        System.out.println(max);
    }

}
