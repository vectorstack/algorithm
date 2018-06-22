package com.vector.sort.InsertSort;

/**
 * Created by 12345 on 2018-6-17.
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        int [] a = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        // 二分插入排序
        sort(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }

    public static void sort(int[] arr){
        for(int i = 1; i< arr.length;i++){
            int left = 0;
            int right = i-1;
            int temp = arr[i];
            int mod;
            while(left <= right){
                mod = (right - left) / 2;
                if(temp < arr[mod]){
                    right = mod -1;
                }else{
                    left = mod + 1;
                }
            }
            for(int j = i -1;j>=left; j--){
                arr[j+1] = arr[j];
            }

            if(left != i){
                arr[left] = temp;
            }

        }
    }
}


