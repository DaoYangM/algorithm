package top.daoyang.sort.quick;

import java.util.Random;

import top.daoyang.sort.utils.Sort;
import top.daoyang.sort.utils.Swap;
import top.daoyang.sort.utils.Test;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        // quickSort(arr, 0, arr.length - 1);
        quickSort3Ways(arr);
    }

    private void quickSort(T[] arr, int l, int r) {
        if (l >= r) return;

        int mid = (l + r) / 2;
        int j = partitionOptimization(arr, l, r);
        quickSort(arr, l, j - 1);
        quickSort(arr, j + 1, r);
    }

    private int partition(T[] arr, int l, int r) {
        Swap.swap(arr, (Math.abs((new Random().nextInt() % (r - l + 1))) + l), l);

        int j = 0;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                Swap.swap(arr, j + 1, i);
                j++;
            }
        }
        Swap.swap(arr, l, j);
        return j;
    }

    private int partitionOptimization(T[] arr, int l, int r) {
        Swap.swap(arr, (Math.abs((new Random().nextInt() % (r - l + 1))) + l), l);
        int i = l, j = r;

        while (true) {
            while (i <= r && arr[i].compareTo(arr[l]) <= 0) i++;
            while (j >= l + 1 && arr[j].compareTo(arr[l]) >= 0) j--;
            if (i > j) break;
            Swap.swap(arr, i, j);
            i++;
            j--;
        }
        Swap.swap(arr, l, j);
        return j;
    }

    public void quickSort3Ways(T[] arr) {
        quickSort3Ways(arr, 0, arr.length - 1);
    }


    // quick sort with 3 ways finally used;
    private void quickSort3Ways(T[] arr, int l, int r) {
        if (l >= r) return;

        Swap.swap(arr, (Math.abs((new Random().nextInt() % (r - l + 1))) + l), l);
        int lt = l, gt = r + 1;
        
        for (int i = l + 1; i < gt; i++) {
            if (arr[l].compareTo(arr[i]) > 0) {
                Swap.swap(arr, lt + 1, i);
                lt++;
            } else if (arr[l].compareTo(arr[i]) < 0) {
                Swap.swap(arr, gt - 1, i);
                gt--;
                i--;
            }
        }
        Swap.swap(arr, l, lt);

        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }

    public static void main(String[] args) {
        Test.test(new QuickSort<Integer>());
    }
}