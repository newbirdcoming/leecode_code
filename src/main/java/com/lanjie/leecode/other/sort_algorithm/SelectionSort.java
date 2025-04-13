package com.lanjie.leecode.other.sort_algorithm;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName SelectionSort$
 * @description 选择排序
 * @date 2025/4/13 14:00
 **/

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums=new int[]{1,23,312,21,22,2};
        selectSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void selectSort(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            int min = nums[i];
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    index = j;
                    min = nums[j];
                }
            }
            if (index != i) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
