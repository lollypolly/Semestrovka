package ru.polly.dictionary;

import java.util.Arrays;

public class EndlessArray<T> {

    private final int BASE_CAPACITY = 10;
    private final float ARRAY_EXPANSION = 1.5f;
    private T[] arr;
    private int elementCount;

    public EndlessArray() {
        arr = (T[]) new Object[BASE_CAPACITY];
        elementCount = 0;
    }

    public EndlessArray(int length) {
        arr = (T[]) new Object[length];
        elementCount = 0;
    }

    public EndlessArray(T[] obj) {
        arr = obj;
        elementCount = arr.length;
    }

    public void add(T num) {
        if (arr.length == elementCount) arr = positiveArrayResize();
        arr[elementCount] = num;
        elementCount++;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= elementCount) throw new IndexOutOfBoundsException();
        arr = negativeArrayResize(index);
        elementCount--;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= elementCount) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public int size() {
        return elementCount;
    }

    public int capacity() {
        return arr.length;
    }

    public int indexOf(T num) {
        for (int i = 0; i < size(); i++) {
            if (num.equals(arr[i])) return i;
        }
        return -1;
    }

    public int lastIndexOf(T num) {
        for (int i = size() - 1; i >= 0; i--) {
            if (num.equals(arr[i])) return i;
        }
        return -1;
    }

    public boolean contains(T num) {
        return indexOf(num) >= 0;
    }

    public T[] getArray() {
        T[] returnArray = (T[]) new Object[size()];
        System.arraycopy(arr, 0, returnArray, 0, size());
        return returnArray;
    }

    private T[] positiveArrayResize() {
        T[] returnArray = (T[]) new Object[(int) (arr.length * ARRAY_EXPANSION)];
        System.arraycopy(arr, 0, returnArray, 0, size());
        return returnArray;
    }

    private T[] negativeArrayResize(int index) {
        T[] returnArray = (T[]) new Object[capacity() - 1];
        System.arraycopy(arr, 0, returnArray, 0, index);
        System.arraycopy(arr, size() - (index - 1), returnArray, size() - index, size() - (index - 1));
        return returnArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;

        EndlessArray that = (EndlessArray) obj;
        return Arrays.equals(arr, that.arr);

    }
}



