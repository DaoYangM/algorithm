package top.daoyang.sort.utils;

public class Swap<T extends Comparable<T>> {

    public static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}