package com.minotaur;


public class Sort {

    private static void print(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print(array[len - 1]);
        System.out.println();
    }

    public static void quickSort(int[] array) {
        int right = array.length - 1;
        int left = 0;
        swap(array, left, right);
        System.out.println("quick sort finish");
        
    }

    private static void swap(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (j > i && array[j] >= mid) {
                j--;
            }
            if (j > i) {
                array[i] = array[j];
            }
            while (i < j && array[i] <= mid) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[i] = mid;
        print(array);
        swap(array, left, i - 1);
        swap(array, i + 1, right);
    }


    /**
     *
     * @param array
     * array
     */
    public static void mergeSort(int[] array) {
        int right = array.length - 1;
        int left = 0;
        sort(array, left, right);
        System.out.println("merge sort finish");
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
        print(array);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] tmpArray = new int[array.length];
        int i = left, n = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                tmpArray[n++] = array[i++];
            } else {
                tmpArray[n++] = array[j++];
            }
        }
        while (i <= mid) {
            tmpArray[n++] = array[i++];
        }
        while (j <= right) {
            tmpArray[n++] = array[j++];
        }
        while (left <= right) {
            array[left] = tmpArray[left++];
        }
    }
}
