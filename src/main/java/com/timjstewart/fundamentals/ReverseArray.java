package com.timjstewart.fundamentals;

import com.timjstewart.utilities.StdOut;

public class ReverseArray {

    public static void reverse(int[] array) {
        final int N = array.length;
        for (int n = 0; n < N / 2; n++) {
            int temp = array[n];
            array[n] = array[N - 1 - n];
            array[N - 1 - n] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        reverse(array);

        for (int n : array)
            StdOut.printf("%d ", n);
    }

}
