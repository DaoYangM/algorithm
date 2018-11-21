package top.daoyang.sort.selection;

import java.util.Arrays;

import top.daoyang.sort.utils.Sort;

public class SelectionSort<T extends Comparable<T>> implements Sort<T>{
    
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length ; j++) 
                if (arr[minIndex].compareTo(arr[j]) > 0)
                    minIndex = j;
            
            swap(arr, minIndex, i);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] test = {8, 6, 2, 3, 1, 5, 7, 4};

        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        selectionSort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}