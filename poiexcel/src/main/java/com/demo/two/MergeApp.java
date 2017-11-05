package com.demo.two;

/**
 * Created by WL on 2017/9/18.
 */
public class MergeApp {

    public static void main(String[] args) {
        int[] arrayA={23,7,56,9};
        int[] arrayB={9,5,2,3,4,6};
        int[] arrayC=new int[10];
        merge(arrayA,4,arrayB,6,arrayC);
        display(arrayC,10);
    }
    public static void merge(int[] arrayA,int sizeA,int[] arrayB,int sizeB,int[] arrayC){
        int aDex=0,bDex=0,cDex=0;
        while (aDex<sizeA && bDex<sizeB){ //A ，B都不为空
            if (arrayA[aDex]<arrayB[bDex]){
                arrayC[cDex++]=arrayA[aDex++];
            }else {
                arrayC[cDex++]=arrayB[bDex++];
            }
        }
        while (aDex<sizeA){ //b为空
            arrayC[cDex++]=arrayA[aDex++];
        }
        while (bDex<sizeB){ //a为空
            arrayC[cDex++]=arrayB[bDex++];
        }
    }
    public static void display(int[] array,int size){
        for (int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }
}
