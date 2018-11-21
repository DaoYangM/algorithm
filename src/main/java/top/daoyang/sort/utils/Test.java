package top.daoyang.sort.utils;

import java.util.Arrays;

public class Test {
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void test(Sort<T> sort) {
        Integer[] test = {4, 6, 2, 3, 1, 5, 7, 8};
        // Integer[] test = {2, 1, 3, 4};
        sort.sort((T[])test); 
        System.out.println(Arrays.toString(test));
    }
}