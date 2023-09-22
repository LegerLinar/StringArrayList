package org.example;

import org.example.StringList.StringArrayList;

import java.util.Arrays;

/**
 * 1026 -- Bubble
 * 1001 -- Selective
 * 1027 -- Insertion
 * finish
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.random() * 1000;
        }
        int[] arr1 = Arrays.copyOf(arr,arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);

        long start = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println(System.currentTimeMillis() - start + "Bubble");

        long start1 = System.currentTimeMillis();
//        selectiveSort(arr);
        System.out.println(System.currentTimeMillis() - start1 + "Selective");

        long start2 = System.currentTimeMillis();
        insertionSort(arr);
        System.out.println(System.currentTimeMillis() - start2 + "Insertion");

        System.out.println("finish");
    }

    public static void swapElements(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

//    public static void selectiveSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minElIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minElIndex]) {
//                    minElIndex = j;
//                }
//            }
//            swapElements(arr, i, minElIndex);
//        }
//    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }




}