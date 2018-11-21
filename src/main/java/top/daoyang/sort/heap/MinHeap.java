package top.daoyang.sort.heap;

import java.lang.Comparable;
import java.lang.reflect.Array;

import top.daoyang.sort.utils.Swap;

public class MinHeap<T extends Comparable<T>> {
    private T[] data;
    private Integer[] indexes;
    private Integer[] reverse;
    private int count;

    @SuppressWarnings("unchecked")
    public MinHeap(int capacity, Class<T> cls) {
        data = (T[]) Array.newInstance(cls, capacity + 1);
        indexes = new Integer[capacity + 1];
        reverse = new Integer[capacity + 1];
        for (int i = 0; i < capacity; i++) {
            reverse[i + 1] = 0;
        }
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(T e) {
        rangeChecked();
        
        data[++count] = e;
        indexes[count] = count;
        reverse[count] = count;
        shiftUp(count);
    }

    public T remove() {
        T root = data[indexes[1]];
        Swap.swap(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count --;
        shiftDown(1);

        return root;
    }

    private void shiftDown(int i) {

        while (i * 2 <= count) {
            int LC = i * 2, RC = i * 2 + 1;

            if (RC <= count && data[indexes[LC]].compareTo(data[indexes[RC]]) > 0) 
                LC = RC;

            if (data[indexes[LC]].compareTo(data[indexes[i]]) >= 0)
                break;

            Swap.swap(indexes, i, LC);
            reverse[indexes[i]] = LC;
            reverse[indexes[LC]] = LC;
            i = LC;
        }
    }

    private void shiftUp(int i) {
        
        while (i > 1 && data[indexes[i / 2]].compareTo(data[indexes[i]]) > 0) {
            Swap.swap(indexes, i / 2, i);
            reverse[indexes[i / 2]] = i / 2;
            reverse[indexes[i]] = i;
            i  = i / 2;
        }
    }

    public void change(int a, T item) {
        a += 1;
        data[a] = item;

        int j = reverse[a];
        shiftUp(j);
        shiftDown(j);
    }

    public boolean contain(int i) {
        if (i + 1 > data.length || i + 1 < 1 )
            throw new IllegalAccessError("out of index");
        return reverse[i+1] != 0;
    }
    private void rangeChecked() {
        if (count >= data.length)
            throw new IllegalAccessError("out of index");
    }

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>(10, Integer.class);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(30);
        minHeap.add(5);
        minHeap.change(2, 6);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.remove());
        }
    }
}