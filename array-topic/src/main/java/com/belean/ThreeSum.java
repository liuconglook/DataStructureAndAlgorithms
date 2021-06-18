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
        List<List<Integer>> list = new ArrayList<>();
        for(int a=0; a<nums.length; a++) {
            for(int b=0; b<nums.length; b++) {
                for(int c=0; c<nums.length; c++) {
                    if(a != b && b != c && c != a) {
                        if((nums[a] + nums[b] + nums[c]) == 0) {
                            List<Integer> group = new ArrayList<>();
                            group.add(nums[a]);
                            group.add(nums[b]);
                            group.add(nums[c]);
                            if(!isContains(list, group)){
                                list.add(group);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
    // 该组合是否已存在
    public static boolean isContains(List<List<Integer>> container, List<Integer> group) {
        for(List<Integer> list : container) {
            if(list.containsAll(group)){
                return true;
            }
        }
        return false;
    }

    /**
     * （2）双指针
     * 时间复杂度：O(n^2)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum02(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int k=0;k<nums.length-2;k++) {
            if(nums[k]>0) break; // 都大于零，玩完
            if(k>0 && nums[k] == nums[k-1]) continue; // 遇到相同的，快速推进
            int i = k + 1, j= nums.length -1; // 摆好位置
            while(i < j) { // 当i等于j就会退出循环，当然还有大于的情况
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0) { // i推进
                    while(i < j && nums[i] == nums[++i]); 
                }else if(sum > 0){ // j推进
                    while(i < j && nums[j] == nums[--j]);
                }else{ // 相等
                    list.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return list;
    }

    
}
