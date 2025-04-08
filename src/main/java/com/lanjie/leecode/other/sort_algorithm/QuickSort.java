package com.lanjie.leecode.other.sort_algorithm;

import java.util.Scanner;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName QuickSort$
 * @description 快速排序
 * @time O(nlogn)
 * @space O(logn)
 * @date 2025/4/8 10:50
 **/
public class QuickSort {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
//        输入
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
//        快排
        quickSort(nums,0,n-1);
//        输出
        System.out.println("归并排序结果：");
        for (int i = 0; i < n-1; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println(nums[n-1]);
    }




//      分割+排序（合并）
    static void quickSort(int[] nums,int l,int r){
        if(l>=r)
            return;
//      支点 pivot
        int pivot=nums[r];
        int i=l-1;
        for(int j=l;j<r;j++){
//            i及左边的数均小于等于pivot
            if(nums[j]<pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
//        最后确定pivot的位置 i（包括i）都小于pivot 交换p
        int temp=nums[i+1];
        nums[i+1]=nums[r];
        nums[r]=temp;
        quickSort(nums,l,i);
        quickSort(nums,i+2,r);
    }



}
