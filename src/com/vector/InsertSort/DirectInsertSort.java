package com.vector.InsertSort;

/**
 * Created by 12345 on 2018-6-17.
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        int [] array = new int[] {47,52,12,36,98,88,57,32};

        System.out.println("before");
        for(int i = 0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();

        for(int i = 1;i<array.length;i++){
            int temp = array[i];
            int j;
            for(j = i-1;j>=0;j--){
                if(temp < array[j]){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = temp;
        }

        System.out.println("afer");
        for(int i = 0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
