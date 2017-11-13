package com.wl.algorithm.quickSort;

import java.util.Arrays;

/**
 * Created by WL on 2017/11/13.
 */
public class QuickSort {
    public static void main(String[] args) {
        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sort(int[] a,int low,int hight){
        int i,j,index;
        if (low>hight){
            return;
        }
        i=low;
        j=hight;
        index=a[low];// 用子表的第一个记录做基准
        while (j>i){// 从表的两端交替向中间扫描
            while (i<j && a[j]>=index){
                j--;
            }
            if (j>i){
                a[i]=a[j];// 用比基准小的记录替换低位记录
                i++;
            }
            while (j>i && a[i]<index){
                i++;
            }
            if (j>i)// 用比基准大的记录替换高位记录
                a[j--]=a[i];
        }
        a[i]=index;// 将基准数值替换回 a[i]
        sort(a,low,i-1); // 对低子表进行递归排序
        sort(a,i+1,hight);// 对高子表进行递归排序
    }
    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }
}
