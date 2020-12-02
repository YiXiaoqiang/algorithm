package com.sean.algorithm.sort;

import java.util.Arrays;

public class Sort {

    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

        return arr;
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

//        iter the left value into array temp
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

//        copy value from temp to arr
        for (int index = 0; index < k; index++) {
            arr[index + left] = temp[index];
        }
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return arr;
        }

        int base = arr[left];
        int i = left;
        int j = right;

        while (i != j) {
            // compare from right, the order from right is very important
            while (base <= arr[j] && i < j) {
                j--;
            }

            // compare from left
            while (base >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //replace arr[i] (i == j) with base
        arr[left] = arr[i];
        arr[i] = base;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        System.out.println("before sort:" + Arrays.toString(arr));
//        System.out.println("after sort:" + Arrays.toString(Sort.mergeSort(arr, 0, arr.length - 1)));
        System.out.println("after sort:" + Arrays.toString(Sort.quickSort(arr, 0, arr.length - 1)));

    }
}
