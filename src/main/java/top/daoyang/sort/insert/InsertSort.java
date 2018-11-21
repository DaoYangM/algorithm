package top.daoyang.sort.insert;

import java.util.Arrays;

import top.daoyang.sort.utils.Sort;

public class InsertSort<T extends Comparable<T>> implements Sort<T> {
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int swapIndex = i;

            for (int j = i; j > 0 ; j--) {
                if (arr[swapIndex].compareTo(arr[swapIndex - 1]) < 0) {
                    swap(arr, swapIndex, swapIndex - 1);
                    swapIndex--;
                } else
                    break;
            }
        }
    }

    private void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] test = {8, 6, 2, 3, 1, 5, 7, 4};

        InsertSort<Integer> insertSort = new InsertSort<>();
        insertSort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}

