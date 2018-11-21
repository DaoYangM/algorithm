package top.daoyang.sort.utils;

public interface Sort<T extends Comparable<T>>  {
    void sort(T[] arr);
}