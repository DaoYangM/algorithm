package top.daoyang.sort.bubble;

import java.util.Arrays;

import top.daoyang.sort.utils.Sort;
import top.daoyang.sort.utils.Swap;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j].compareTo(arr[j+1]) > 0)
                    Swap.swap(arr, j, j+1);
        }
    }

    public static void main(String[] args) {
        Integer[] test = {8, 6, 2, 3, 1, 5, 7, 4};
        
        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}