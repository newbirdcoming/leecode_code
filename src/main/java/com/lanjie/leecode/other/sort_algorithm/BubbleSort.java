package com.lanjie.leecode.other.sort_algorithm;

import java.util.Scanner;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName BubbleSort$
 * @description 冒泡排序(从小到大)
 * @time O(n^2) 最好情况下O(n)
 * @space O(1)
 * @date 2025/4/8 10:51
 **/
public class BubbleSort {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
        // 输入
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
        //冒泡排序
        bubbleSort(nums);
        //输出
        System.out.println("冒泡排序结果：");
        for (int i = 0; i < n-1; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println(nums[n-1]);
    }

    private static void bubbleSort(int[] nums) {
        for(int i=0;i<nums.length;i++){
//          提前结束标识 当已排序直接结束、优化算法
            boolean swap=false;
            for(int j=1;j<nums.length-i;j++){
                if(nums[j]<nums[j-1]){
                    int temp=nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                    swap=true;
                }
            }
            if(!swap)
                break;
        }
    }
}
