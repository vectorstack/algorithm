package com.vector.SelectSort;

/**
 * Created by 12345 on 2018-6-17.
 */
public class DirectSelectSort {
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        for(int i = 0;i < a.length;i++){
            int min = a[i];
            int index = i;
            for(int j = i+1; j< a.length;j++){
                if(a[j] < min){
                    min = a[j];
                    index = j;
                }
            }
            a[index] = a[i];
            a[i] = min;

        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}
