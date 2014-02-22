package com.timjstewart.fundamentals;

import static junit.framework.Assert.assertEquals;

public class BinarySearch {

    public static int rank(
            final int n,
            final int[] a
    ) {
        int low = 0;
        int high = a.length;

        while (low < high) {
            final int mid = low + (high - low) / 2;
            if      (a[mid] > n)  { high = mid; }
            else if (a[mid] < n)  { low  = mid + 1; }
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        for (int n : array)
            assertEquals(n, rank(n, array));

        assertEquals(-1, rank(-10, array));
        assertEquals(-1, rank(11, array));
        assertEquals(-1, rank(-10, array));
    }

}
