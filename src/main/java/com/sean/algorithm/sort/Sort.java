package com.sean.algorithm.sort;

import java.util.Arrays;

public class Sort {

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);

        return arr;
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
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

        while (j <= end) {
            temp[k++] = arr[j++];
        }

//        copy value from temp to arr
        for (int index = 0; index < k; index++) {
            arr[index + start] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] arr = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        System.out.println("before sort:" + Arrays.toString(arr));
        System.out.println("after sort:" + Arrays.toString(Sort.mergeSort(arr, 0, arr.length - 1)));

    }
}
