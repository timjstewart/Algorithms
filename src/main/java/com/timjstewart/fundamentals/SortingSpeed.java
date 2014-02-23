package com.timjstewart.fundamentals;

import com.timjstewart.utilities.StdOut;
import com.timjstewart.utilities.StdRandom;
import com.timjstewart.utilities.Stopwatch;

import java.util.Arrays;

public class SortingSpeed {

   public static void main(String[] args) {

      double lastTime = 0.0;

      for (int size = 1024; size < 10_000_000; size *= 2) {

         int[] a = new int[size];

         for (int n = 0; n < size; n++) {
            a[n] = StdRandom.uniform(Integer.MAX_VALUE);
         }

         Stopwatch watch = new Stopwatch();

         Arrays.sort(a);

         final double thisTime = watch.elapsedTime();

         StdOut.printf("%.3f seconds to sort %d elements.", thisTime, size);

         if (lastTime != 0.0) {
            StdOut.printf("  Ratio (last time/ this time): %.3f\n", lastTime / thisTime);
         } else {
            StdOut.println();
         }
         lastTime = thisTime;
      }
   }

}
