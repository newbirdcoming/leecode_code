package com.lanjie.leecode.company.tengxunyunzhi.T1;

import java.util.*;


public class Main{
    static int[][] dic=new int[][]{{0,0},{0,1},{0,-1},{1,0},{-1,0}};
    static int max=0;
    static int count=0;
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int[][] nums=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                nums[i][j]=in.nextInt();
        }
        List<int[]> curNums=new ArrayList<>();
        int l=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if (nums[i][j] != 0) {
                    curNums.add(new int[]{i,j,getCurMax(i, j, nums, n)});
                }

            }
        }
        Collections.sort(curNums,(o1,o2)->{
            return o2[2]-o1[2];
        });

        for(int[] v:curNums){
            if(nums[v[0]][v[1]]!=0) {
                gunOn(v[0], v[1], nums, n);
                count++;
            }
        }
        System.out.print("count"+count);
        System.out.print("max"+max);
    }

    static int getCurMax(int x,int y,int[][] nums,int n){
        int sum=0;
        for(int i=0;i<5;i++){
            int nextX=x+dic[i][0];
            int nextY=y+dic[i][1];
            if(nextX>=0&&nextX<n&&nextY>=0&&nextY<n){
                sum+=nums[nextX][nextY];
            }
        }
        max=Math.max(max,sum);
        return sum;
    }

    static void gunOn(int x,int y,int[][] nums,int n){
        int sum=0;
        for(int i=0;i<5;i++){
            int nextX=x+dic[i][0];
            int nextY=x+dic[i][1];
            if(nextX>=0&&nextX<n&&nextY>=0&&nextY<n){
                nums[nextX][nextY]=0;
            }
        }
    }



}