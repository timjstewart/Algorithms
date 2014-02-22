package com.timjstewart.fundamentals;

import static junit.framework.Assert.*;

public class Converter {

    public static String toBinary(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("This limited implementation of toBinary only accepts positive numbers");
        }

        StringBuilder sb = new StringBuilder();

        do {
            sb.insert(0, n % 2);
            n >>= 1; // or n /= 2
        } while (n > 0);

        return sb.toString();
    }

    public static void main(String[] args) {
        assertEquals("0", toBinary(0));
        assertEquals("1", toBinary(1));
        assertEquals("10", toBinary(2));
        assertEquals("11", toBinary(3));
        assertEquals("101", toBinary(5));
        assertEquals("100", toBinary(4));
    }

}
