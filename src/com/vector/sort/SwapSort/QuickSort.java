package com.vector.sort.SwapSort;

/**
 * Created by 12345 on 2018-6-22.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("����֮ǰ��");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        // ��������
        quick(a);
        System.out.println();
        System.out.println("����֮��");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }

    private static void quick(int[] a){
        if (a.length > 0)
        {
            quickSort(a, 0, a.length - 1);
        }
    }

    private static void quickSort(int[] a, int low, int high){
        if (low < high)
        { // �����������жϵݹ���޷��˳����¶�ջ����쳣
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    private static int getMiddle(int[] a, int low, int high)
    {
        int temp = a[low];// ��׼Ԫ��
        while (low < high)
        {
            // �ҵ��Ȼ�׼Ԫ��С��Ԫ��λ��
            while (low < high && a[high] >= temp)
            {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp)
            {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

}