package com.lanjie.leecode.other.sort_algorithm;

/**
 * @author Mr.Lan
 * @version 1.0
 * @ClassName MergeSort$
 * @description 归并排序
 * @time O(nlogn)
 * @space O(n)+O(logn)=O(n)
 * @date 2025/4/8 10:23
 **/

import java.util.*;


class MergeSort{
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int[] nums=new int[n];
//        输入
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
//        快排
        int[] newNums=mergeSort(nums,0,n-1);
//        输出
        System.out.println("归并排序结果：");
        for (int i = 0; i < n-1; i++) {
            System.out.print(newNums[i]+" ");
        }
        System.out.println(newNums[n-1]);
    }





    static int[] mergeSort(int[] nums,int l,int r){
//        分
        if(l==r)
            return new int[]{nums[l]};
        int mid=(l+r)/2;
        int[] leftArr = mergeSort(nums,l,mid);
        int[] rightArr= mergeSort(nums,mid+1,r);
//        合
       int m=leftArr.length+rightArr.length;
       int[] newNums=new int[m];
       int i=0,j=0,k=0;
       while(i<leftArr.length&&j<rightArr.length){
           newNums[k++]=leftArr[i]<rightArr[j]?leftArr[i++] :rightArr[j++];
       }
       while(i<leftArr.length){
           newNums[k++]=leftArr[i++];
       }
       while(j<rightArr.length){
            newNums[k++]=rightArr[j++];
       }
       return newNums;

    }



}
