package top.daoyang.sort.merge;

import java.lang.reflect.Array;
import java.util.Arrays;

import top.daoyang.sort.utils.Sort;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    private Class<T> cla;

    public MergeSort(Class<T> t) {
        cla = t;        
    }

    public void sort(T[] arr) {
        // mergeSort(arr, 0, arr.length - 1);  
        mergeSortBU(arr);      
    }

    private void mergeSort(T[] arr, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    private void mergeSortBU(T[] arr) {
        for (int sz = 1; sz < arr.length; sz = sz + sz) {
            for (int i = 0; i + sz < arr.length; i = i + sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz +sz - 1, arr.length - 1));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] arr, int l, int mid, int r) {
        T[] temp = (T[])Array.newInstance(cla, r - l + 1);

        for (int i = l; i <= r; i++) 
            temp[i - l] = arr[i];
        
        int i = l, k = mid + 1, j = r;
        for (int v = 0; v <= r - l; v++) {
            if (i >= mid + 1) {
                arr[l + v] = temp[k - l];
                k++;
            } else if (k > r) {
                arr[l + v] = temp[i - l];
                i++;
            }
            else if (temp[i - l].compareTo(temp[k - l]) < 0) {
                arr[l + v] = temp[i - l];
                i++;
            } else if(temp[i - l].compareTo(temp[k - l]) > 0) {
                arr[l + v] = temp[k - l];
                k++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] test = {8, 6, 2, 3, 1, 5, 7, 4};
        Sort<Integer> mergeSort = new MergeSort<>(Integer.class);
        mergeSort.sort(test);       
        System.out.println(Arrays.toString(test));
    }
}